package com.ihmphr.spring.config;

// import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
// import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.social.security.SpringSocialConfigurer;


@Configuration
@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	@Qualifier("ihmphrUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        /**
         * This code is for in memory authentication
         * auth
         *   .inMemoryAuthentication()
         *       .withUser("test").password("testpassword").roles("USER");
         */
		 
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
    }
	
	private PasswordEncoder passwordEncoder() {
		// TODO Auto-generated method stub
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder;
	}

	@Override
	protected void configure( HttpSecurity http ) throws Exception {
		
		
		/*
		http.authorizeRequests().
		                        antMatchers("/profile/**").access("hasRole('ROLE_USER')");
		                        
		http.formLogin().loginPage("/login").permitAll()
		    .failureUrl("/login?error")
		    .usernameParameter("username").passwordParameter("password")
		                        .and()
		                        .logout()
		                        .logoutSuccessUrl("/login?logout")
		                        .deleteCookies("JSESSIONID");*/
		
		
	    http.authorizeRequests().antMatchers("/profile/**")
			.access("hasRole('ROLE_USER')").and().formLogin()
			.loginPage("/login").failureUrl("/login?error")
			.usernameParameter("username")
			.passwordParameter("password")
			//.and().logout().logoutSuccessUrl("/login?logout")
			.and().logout().logoutSuccessUrl("/profile")
			.and().csrf()
			.and().exceptionHandling().accessDeniedPage("/403");
		                        
		                         /** Following section to be enabled for Spring Social Login
		                         *  
		                         */
		
		                        /**.and()
		                        .apply(new SpringSocialConfigurer().postLoginUrl("/").alwaysUsePostLoginUrl(true));	*/	                        ;
		                       
		
	}
	
	 

}
