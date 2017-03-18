/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package extp.store.configs;

import com.google.gson.GsonBuilder;
import extp.store.services.CookieService;
import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.core.env.Environment;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 *
 * @author Ollaberganov-PC
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"extp.store.controller", "extp.store.dto", "extp.store.services", "extp.store.dao"})
@PropertySource(value = {"classpath:application.properties"})
public class MvcConfig extends WebMvcConfigurerAdapter {
    
    @Autowired
    private Environment environment;
    
    final String cookiesName = "estore";
       
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    @Bean
    public InternalResourceViewResolver jspViewResolver() {
        InternalResourceViewResolver bean = new InternalResourceViewResolver();        
        bean.setPrefix("/WEB-INF/");
        bean.setSuffix(".jsp");
        return bean;
    }
    
    @Bean(name = "multipartResolver")
    public CommonsMultipartResolver multipartResolver() {
        CommonsMultipartResolver resolver=new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        resolver.setMaxUploadSize(13107200);
        return resolver;
    }
    
    @Bean(name = "messageSource")
    public ResourceBundleMessageSource getMessageSource() {
        ResourceBundleMessageSource resource = new ResourceBundleMessageSource();
        resource.setBasename("i18n/messages");
        resource.setDefaultEncoding("UTF-8");        
        return resource;
    }
    
    @Bean
    public GsonBuilder getGson() {
        return new GsonBuilder().setDateFormat("yyyy.MM.dd HH:mm:ss").disableHtmlEscaping().setPrettyPrinting();
    }

    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver clr = new CookieLocaleResolver();
        clr.setDefaultLocale(new Locale("uz"));
        return clr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    
    @Bean
    public LayoutInterceptor otherInterceptor() {
        LayoutInterceptor layout = new LayoutInterceptor();
        layout.setAuthLayoutView("templates/auth");
        layout.setLayoutView("templates/layout");        
        return layout;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
        registry.addInterceptor(otherInterceptor());
    }
    
    @Bean
    public CookieService cookieService(){
        return new CookieService(cookiesName);
    }
    
     
//    @Bean
//    public ServiceDto applicationProperty() {
//        ServiceDto dto = new ServiceDto();
//        dto.setHost(environment.getProperty("host"));
//        return dto;
//    }
      
}

