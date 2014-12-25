package com.ihmphr.spring.config;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
// import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
// import org.springframework.orm.hibernate3.HibernateTransactionManager;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBuilder;
import org.springframework.core.env.Environment;


@Configuration
@EnableWebMvc
@ComponentScan("com.ihmphr.spring.*")
@EnableTransactionManagement
@PropertySource("classpath:application.properties")
@Import({SecurityConfig.class})
public class ApplicationContextConfig extends WebMvcConfigurationSupport  {
	
	@Inject
	private Environment environment;
	
	@Bean(name="viewResolver")
	public  InternalResourceViewResolver getViewResolver(){
		
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
		
	}
	
	@Bean(name = "dataSource")
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	   
	    /*
	    dataSource.setDriverClassName(environment.getProperty("database.driverClassName"));
	    dataSource.setUrl(environment.getProperty("database.driverClassName"));
	    dataSource.setUsername(environment.getProperty("database.username"));
	    dataSource.setPassword(environment.getProperty("database.password"));*/
	    
	    
	    System.out.println("DataBase user name :- "+ environment.getProperty("database.username") );
	    
	    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
	    dataSource.setUrl("jdbc:mysql://localhost:3306/DEV");
	    dataSource.setUsername("dev");
	    dataSource.setPassword("dev123");
	    
	    
	    
	    return dataSource;
	}
	
	@Autowired
	@Bean(name = "sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) {
	 
	    LocalSessionFactoryBuilder sessionBuilder = new LocalSessionFactoryBuilder(getDataSource());
	    sessionBuilder.scanPackages("com.ihmphr.spring.model");
	    sessionBuilder.setProperty("hibernate.show_sql", "true");
	    sessionBuilder.setProperty("hibernate.format_sql", "true");
	    sessionBuilder.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
	 
	    return sessionBuilder.buildSessionFactory();
	}
	
	@Autowired
	@Bean(name = "transactionManager")
	public HibernateTransactionManager getTransactionManager(
	        SessionFactory sessionFactory) {
	    HibernateTransactionManager transactionManager = new HibernateTransactionManager(
	            sessionFactory);
	 
	    return transactionManager;
	}

}
