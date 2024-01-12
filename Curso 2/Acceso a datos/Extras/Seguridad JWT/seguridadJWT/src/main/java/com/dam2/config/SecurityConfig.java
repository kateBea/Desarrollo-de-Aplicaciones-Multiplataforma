package com.dam2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        /*http.csrf().disable()
            .authorizeRequests()
            .anyRequest()
            .hasRole("CLIENT")    
            .and().httpBasic();
        */
    	System.out.println("ejecutando SecurityConfig");
    	http.csrf().disable().
    		addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class).
    		authorizeRequests().
    		antMatchers("/mensajes").permitAll(). // sin autorización
    		antMatchers("/token/mensajes").authenticated(). // con token
    		antMatchers("/token").hasRole("CLIENT").and().httpBasic(); // autorización usuario y contraseña
    		//antMatchers("/mensajes/post").hasRole("CLIENT").and().httpBasic(); // autorización usuario y contraseña
    		
    		//antMatchers("/token").
        
        
    }

    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //No password encrypt for demo proposes only (do NOT use in Prod environments)!!
        auth.inMemoryAuthentication()
            .withUser("client")
            .password("{noop}client")
            .roles("CLIENT");
        
        auth.inMemoryAuthentication()
        .withUser("client2")
        .password("{noop}client2")
        .roles("CLIENT");
    }
}