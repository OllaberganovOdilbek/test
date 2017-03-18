/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.configs;

import com.google.gson.GsonBuilder;
import extp.store.filter.BaseFilter;
import extp.store.services.CookieService;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

/**
 *
 * @author Ollaberganov-PC
 */
public class WebAppInitializer implements WebApplicationInitializer{
    
    @Override
    public void onStartup(ServletContext container) {
        
        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(MvcConfig.class,DatabaseConfig.class);
        
        dispatcherServlet.setServletContext(container);
        dispatcherServlet.refresh();
        
        CookieService cookieservice = (CookieService)dispatcherServlet.getBean("cookieService"); 
        final GsonBuilder gsonBuilder = (GsonBuilder) dispatcherServlet.getBean("getGson");
        
        // Register and map the dispatcher servlet
        ServletRegistration.Dynamic dispatcher = container.addServlet("dispatcher", new DispatcherServlet(dispatcherServlet));
        dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        FilterRegistration.Dynamic filter = container.addFilter("BaseFilter", new BaseFilter(cookieservice, gsonBuilder));
        filter.addMappingForUrlPatterns(null, true, "/store/*");

    }
}

