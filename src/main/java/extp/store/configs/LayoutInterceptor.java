/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.configs;

import extp.store.dto.SecurityDto;
import extp.store.services.CookieService;
import java.util.Locale;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.RequestContextUtils;

/**
 *
 * @author Ollaberganov-PC
 */
public class LayoutInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private CookieService cookieservice;

    private static final String NO_LAYOUT = "noLayout:";

    private String authlayoutView;    
    private String layoutView;    
    
    public void setAuthLayoutView(String authlayoutView) {
        this.authlayoutView = authlayoutView;
    }
    
    public void setLayoutView(String layoutView) {
        this.layoutView = layoutView;
    }

    @Override
    public void postHandle(HttpServletRequest req, HttpServletResponse res, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(req, res, handler, modelAndView);

        SecurityDto security = cookieservice.getCookies(req);

        String originalView = modelAndView != null ? modelAndView.getViewName() : null;
        LocaleResolver localeResolver = RequestContextUtils.getLocaleResolver(req);

        if (req.getParameter("lang") != null && !"".equals(req.getParameter("lang"))) {
            localeResolver.setLocale(req, res, new Locale(req.getParameter("lang")));
        }
        if (originalView != null && !originalView.startsWith("redirect:")) {
            String lang = localeResolver.resolveLocale(req).getLanguage();
            includeLayout(modelAndView, originalView);

            modelAndView.addObject("lang", lang);
            modelAndView.addObject("application", security);
            modelAndView.addObject("owner", security.getFio());
        }
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {       
        return super.preHandle(request, response, handler);
    }
    
    private void includeLayout(ModelAndView modelAndView, String originalView) {
        boolean noLayout = originalView.startsWith(NO_LAYOUT);
        String realViewName = (noLayout) ? originalView.substring(NO_LAYOUT.length()) : originalView;        
        if (realViewName.startsWith("auth/")) {
            modelAndView.addObject("view", realViewName);
            modelAndView.setViewName(authlayoutView);            
        } else {
            modelAndView.addObject("view", realViewName);
            modelAndView.setViewName(layoutView);
        }
    }
    
}

