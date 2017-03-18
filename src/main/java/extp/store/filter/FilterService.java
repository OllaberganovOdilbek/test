/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.filter;

import com.google.gson.GsonBuilder;
import extp.store.dto.SecurityDto;
import extp.store.services.CookieService;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ollaberganov-PC
 */
public class FilterService implements Filter {

    private final String encoding = "UTF-8";

    protected boolean checkAuthorization = true;
    protected CookieService cookieservice;
    protected GsonBuilder gsonBuilder;
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(encoding);
        response.setContentType("text/html; charset=" + encoding);
        response.setCharacterEncoding(encoding);

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        SecurityDto security = cookieservice.getCookies(httpRequest);
        if (!security.isIsactive()) {
            httpResponse.sendRedirect("/auth/in");         
        } else {
            chain.doFilter(httpRequest, httpResponse);
        }

    }
}
