package com.home.socialMember.config;

import org.springframework.context.annotation.*;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class MvcConfig implements WebMvcConfigurer{
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}
	
	public void configureViewResolvers(ViewResolverRegistry registry) {
		registry.jsp("/WEB-INF/page/", ".jsp"); 

	}
	
	public void addViewControllers(ViewControllerRegistry registry){
		registry.addViewController("/").setViewName("main");
	} 
}
