package com.dam2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class MultiHttpSecurityConfig {

	@Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //No password encrypt for demo proposes only (do NOT use in Prod environments)!!
		System.out.println("estoy cargando los usuarios y contraseñas para la autentificación básica");
        auth.inMemoryAuthentication()
            .withUser("client")
            .password("{noop}client")
            .roles("CLIENT");
        
        auth.inMemoryAuthentication()
        .withUser("client2")
        .password("{noop}client2")
        .roles("CLIENT");
    }
	
	 @Configuration
     @Order(1)  
	 public static class SecurityConfigToken extends WebSecurityConfigurerAdapter {
	
		 @Override
		    protected void configure(HttpSecurity http) throws Exception {
			 System.out.println("estoy cargando autorización con token para controlador /token");

		    	http.csrf().disable().
		    		addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class).
		    		antMatcher("/token/**").authorizeRequests().
		    		antMatchers(HttpMethod.POST, "/token").permitAll().
		    		antMatchers("/token/mensajes").authenticated(); 
		    		
		    }
		 
	 }
	 
	 @Configuration
     //@Order(2)  
	 public static class SecurityConfigUser extends WebSecurityConfigurerAdapter {
	
		 @Override
		    protected void configure(HttpSecurity http) throws Exception {
			 System.out.println("estoy cargando autorización básica para controlador /mensajes");
		        http.csrf().disable()
		        	.antMatcher("/mensajes/**")
		            .authorizeRequests()
		            .anyRequest()
		            .hasRole("CLIENT")    
		            .and().httpBasic();
		        
		    }
		 
	 }
	 
	 
	
}
