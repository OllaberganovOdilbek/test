/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.services;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
import extp.store.dto.SecurityDto;
import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ollaberganov-PC
 */
public class CookieService {

    final String cookiesName;

    public CookieService(String cookiesName) {
        this.cookiesName = cookiesName;
    }

    public SecurityDto getCookies(HttpServletRequest req) {
        SecurityDto appObj = null;

        Cookie result = getCookiesByName(req, this.cookiesName);

        if (result != null) {
            try {
                String value = new String(Base64.decode(URLDecoder.decode(result.getValue(), "UTF-8")));
                appObj = new JSONDeserializer<SecurityDto>().deserialize(value);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (Base64DecodingException e) {
                e.printStackTrace();
            }
        }

        if (appObj == null) {
            appObj = new SecurityDto();
            appObj.setIsactive(false);
        }
        return appObj;
    }

    public void writeCookie(HttpServletResponse res, SecurityDto appObj) {
        String value = new JSONSerializer().serialize(appObj);
        try {
            writeCookie(res, this.cookiesName, URLEncoder.encode(Base64.encode(value.getBytes()), "UTF-8"));
        } catch (Exception e) {
        }

    }

    public void writeCookie(HttpServletResponse res, String name, String data) {
        Cookie newCookie = new Cookie(name, data);
        newCookie.setPath("/");
        newCookie.setMaxAge(3600);
        res.addCookie(newCookie);
    }

    public void removeCookie(HttpServletRequest req, HttpServletResponse res) {
        removeCookie(req, res, this.cookiesName);
    }

    public void removeCookie(HttpServletRequest req, HttpServletResponse res, String name) {
        Cookie result = getCookiesByName(req, name);
        if (result != null) {
            result.setMaxAge(0);
            result.setPath("/");
            res.addCookie(result);
        }
    }

    public void removeAllCookie(HttpServletRequest req, HttpServletResponse res) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0);
                cookie.setPath("/");
                res.addCookie(cookie);
            }
        }
    }

     

    public Cookie getCookiesByName(HttpServletRequest req, String name) {
        Cookie result = null;
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals(name)) {
                    result = cookie;
                }
            }
        }
        return result;
    }

    public String getRemoteAddr(HttpServletRequest req) {
        if (req.getHeader("X-Real-IP") != null && !"".equals(req.getHeader("X-Real-IP"))) {
            return req.getHeader("X-Real-IP");
        }
        return req.getRemoteAddr();
    }
    
}


