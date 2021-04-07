
package com.app.startup.config.mvc;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Properties;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
public class SpringViewConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("bower_components/**").addResourceLocations("classpath:/static/bower_components/");
        registry.addResourceHandler("img/**").addResourceLocations("classpath:/static/img/");
        registry.addResourceHandler("js/**").addResourceLocations("classpath:/static/js/");
        registry.addResourceHandler("css/**").addResourceLocations("classpath:/static/css/");
        registry.addResourceHandler("icon_fonts_assets/**")
                .addResourceLocations("classpath:/static/icon_fonts_assets/");
        registry.addResourceHandler("/apple-touch-icon.png")
                .addResourceLocations("classpath:/static/apple-touch-icon.png");
        registry.addResourceHandler("/favicon.png").addResourceLocations("classpath:/static/favicon.png");
    }

    @Bean
    @Description("Locale resolver for resource bundle")
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }

    @Bean
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("resource_bundle/core/application");
        messageSource.setDefaultEncoding("UTF-8");
        messageSource.setCacheSeconds(10); // reload messages every 10 seconds
        return messageSource;
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addRedirectViewController("/index", "index");
    }

    @Bean(name = "urlViewController")
    public UrlFilenameViewController getUrlViewController() {
        return new UrlFilenameViewController();
    }

    @Bean(name = "simpleUrlHandlerMapping")
    public SimpleUrlHandlerMapping getUrlHandlerMapping() {
        SimpleUrlHandlerMapping handlerMapping = new SimpleUrlHandlerMapping();
        Properties mappings = new Properties();
        mappings.put("/users/**", "userController");
        mappings.put("/roles/**", "roleController");
        mappings.put("/authorities/**", "authorityController");
        mappings.put("/products/**", "productController");
        mappings.put("/sales/**", "salesController");
        mappings.put("/vendors/**", "vendorController");
        mappings.put("/auth/**", "authenticationController");
        mappings.put("/error", "customErrorController");
        mappings.put("/**/*.html", "urlViewController");
        handlerMapping.setMappings(mappings);
        return handlerMapping;
    }

    @Bean
    public MappingJackson2HttpMessageConverter customJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter messageConverter = new MappingJackson2HttpMessageConverter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        mapper.registerModule(new JodaModule());
        // mapper.registerModule(new DateTimeModule());
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm a z");
        mapper.setDateFormat(df);

        Hibernate5Module hibernate5Module = new Hibernate5Module();
        hibernate5Module.disable(Hibernate5Module.Feature.FORCE_LAZY_LOADING);

        mapper.registerModule(hibernate5Module);

        messageConverter.setObjectMapper(mapper);
        return messageConverter;
    }

}
