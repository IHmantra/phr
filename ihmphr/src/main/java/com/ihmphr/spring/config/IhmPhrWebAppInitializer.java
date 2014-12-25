package com.ihmphr.spring.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



@Order(1)
public class IhmPhrWebAppInitializer implements WebApplicationInitializer  {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		
		AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
		appContext.register(ApplicationContextConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(appContext));
					
		appContext.setServletContext(servletContext);
		ServletRegistration.Dynamic dispatcher = servletContext.addServlet("SpringDispatcher", new DispatcherServlet(appContext));
		
		dispatcher.setLoadOnStartup(1);
        dispatcher.addMapping("/");
        
        		
	}
	
	protected void afterSpringSecurityFilterChain(ServletContext servletContext) {
		
		servletContext.getFilterRegistration("springSecurityFilterChain").addMappingForUrlPatterns(EnumSet.of(DispatcherType.REQUEST, DispatcherType.FORWARD,DispatcherType.ERROR), true, "/**");
	}
	

}
