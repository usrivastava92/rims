
package com.rims.startup.configuration;

import java.util.Properties;

import com.rims.controllers.IndexController;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Description;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.mvc.UrlFilenameViewController;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import org.thymeleaf.extras.springsecurity4.dialect.SpringSecurityDialect;
import org.thymeleaf.spring5.SpringTemplateEngine;
import org.thymeleaf.spring5.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

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
	@Description("Thymeleaf template resolver serving HTML 5")
	public ClassLoaderTemplateResolver templateResolver() {
		ClassLoaderTemplateResolver templateResolver = new ClassLoaderTemplateResolver();
		templateResolver.setPrefix("templates/");
		templateResolver.setCacheable(false);
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML");
		templateResolver.setCharacterEncoding("UTF-8");
		return templateResolver;
	}

	@Bean
	@Description("Thymeleaf template engine with Spring integration")
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new SpringSecurityDialect());
		templateEngine.addDialect(new Java8TimeDialect());
		return templateEngine;
	}

	@Bean
	@Description("Thymeleaf view resolver")
	public ViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
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
	public SimpleUrlHandlerMapping getUrlHandlerMapping(IndexController indexController) {
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

}
