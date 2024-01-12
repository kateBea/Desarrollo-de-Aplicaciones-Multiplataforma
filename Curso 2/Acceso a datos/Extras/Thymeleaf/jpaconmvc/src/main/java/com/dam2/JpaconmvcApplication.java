package com.dam2;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class JpaconmvcApplication  extends WebMvcConfigurerAdapter 
{

	public static void main(String[] args) {
		SpringApplication.run(JpaconmvcApplication.class, args);
	}

	@Bean
	 public MessageSource messageSource() {
	 ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
	 messageSource.setBasename("messages");
	 return messageSource;
	 }
	 @Bean
	 public SessionLocaleResolver localeResolver() {
	 SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
	 sessionLocaleResolver.setDefaultLocale(Locale.ENGLISH);
	 return sessionLocaleResolver;
	 }
	 @Bean
	 public LocaleChangeInterceptor localeChangeInterceptor() {
	 LocaleChangeInterceptor result = new LocaleChangeInterceptor();
	 result.setParamName("lang");
	 return result;
	 }
	 @Override
	 public void addInterceptors(InterceptorRegistry registry) {
	 registry.addInterceptor(localeChangeInterceptor());
	 }
	
}
