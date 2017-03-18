/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.controller;

import extp.store.services.DatabaseService;
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
@RequestMapping("/store")
public class HomeController {

    @Autowired
    public DatabaseService databaseService;

    
    @RequestMapping(value = "/home", method = RequestMethod.GET)
    public String homePage(HttpServletRequest req, HttpServletResponse res) {     
        return "main/home";
    }
    
    @RequestMapping(value = "/task", method = RequestMethod.GET)
    public String task(Model model,HttpServletRequest req, HttpServletResponse res) { 
        model.addAttribute("data",databaseService.SetTestData());
        return "main/task";
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.GET)
    public String product(Model model,HttpServletRequest req, HttpServletResponse res) {         
        model.addAttribute("data","");
        return "main/product";
    }
    
    @RequestMapping(value = "/product", method = RequestMethod.POST)
    public String productSet(Model model,HttpServletRequest req, HttpServletResponse res) { 
        String name=(req.getParameter("name")!=null ? req.getParameter("name") : "");
        int count=(req.getParameter("count")!=null ? Integer.parseInt(req.getParameter("count")) : 0);
        model.addAttribute("data",databaseService.SetProduct(name,count));
        return "main/product";
    }
}

