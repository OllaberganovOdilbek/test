/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.controller;

import extp.store.dto.SecurityDto;
import extp.store.dto.UserDto;
import extp.store.services.UtilServices;
import extp.store.services.CookieService;
import extp.store.services.AuthService;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author Ollaberganov-PC
 */

@Controller
@RequestMapping("/auth")
public class AuthController {
 
     
    @Autowired
    private CookieService cookieService;
    
    @Autowired
    public AuthService authService;
    
    
    @RequestMapping(value = "/in", method = RequestMethod.GET)
    public String authPage(Model model, HttpServletRequest req, HttpServletResponse res) throws IOException {
        SecurityDto appObj = cookieService.getCookies(req);
        if (appObj.isIsactive()) {
            res.sendRedirect("/store/home");
        } else {
            cookieService.removeCookie(req, res);
        }
        model.addAttribute("msg", "");
        return "auth/login";
    }
    
    @RequestMapping(value = "/in", method = RequestMethod.POST)
    public String authpost(Model model,HttpServletRequest req, HttpServletResponse res) throws IOException, NoSuchAlgorithmException {     
        SecurityDto appObj = cookieService.getCookies(req);
        
        String login=(req.getParameter("login")!=null ? req.getParameter("login") : "");
        String password=(req.getParameter("password")!=null ? req.getParameter("password") : "");
        
        String passmd5=UtilServices.md5("estore"+password); 
        UserDto user=authService.CheckLoginPassword(login, passmd5);
        if(user.getFio()!=null && !user.getFio().equals("")) {
            appObj.setIsactive(true);
            appObj.setFio(user.getFio());
            cookieService.writeCookie(res, appObj);
            return "redirect:/store/home";
        }else{
            model.addAttribute("msg", "Login yoki parol noto'g'ri kiritilgan");
            return "auth/login";
        }
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signup(Model model,HttpServletRequest req, HttpServletResponse res) throws IOException {             
        model.addAttribute("msg","");
        model.addAttribute("success",1);
        return "auth/signup";
    }
    
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public String signuppost(Model model,HttpServletRequest req, HttpServletResponse res) throws IOException, NoSuchAlgorithmException {             
        String msg = "";
        int success = 1;
        String fio=(req.getParameter("fio")!=null ? req.getParameter("fio") : "");
        String login=(req.getParameter("login")!=null ? req.getParameter("login") : "");
        String password=(req.getParameter("password")!=null ? req.getParameter("password") : "");
        
        if(fio.equals("") || login.equals("") || password.equals("")){
            msg="Ma'lumotlarni kiriting";
            success=0;
        }else{
            if(authService.CheckLogin(login)){ // login unikalniymi?
                String passmd5=UtilServices.md5("estore"+password);                
                if(authService.SetUser(fio, login, passmd5)){  // bazaga saqlandi                    
                    msg="Foydalanuvchi registratsiyadan muvaffaqiyatli o'tdi";
                    success=1;
                }else{
                    msg="Registratsiya jarayonida xatolik boldi";
                    success=0;
                }   
            }else{
                msg="Bu foydalanuvchi oldin kiritilgan";
                success=0;
            }
        }
        model.addAttribute("msg",msg);
        model.addAttribute("success",success);
        
        return "auth/signup";
    }
    
    @RequestMapping(value = "/out", method = RequestMethod.GET)
    public void logout(HttpServletResponse res, HttpServletRequest req) throws IOException {
        cookieService.removeCookie(req, res);
        res.sendRedirect("/auth/in");
    }
    
}
 