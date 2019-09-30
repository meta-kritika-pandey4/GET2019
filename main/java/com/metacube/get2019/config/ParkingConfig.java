package com.metacube.get2019.config;

import org.modelmapper.ModelMapper;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.metacube.get2019.filter.SessionFilter;

/**
 * Configuration file 
 * @author Kritika
 *
 */
@Configuration
public class ParkingConfig {
	
	@Bean
	public ModelMapper modelMapper() {
	   ModelMapper modelMapper = new ModelMapper();
	   return modelMapper;	
	}
	
	@Bean
	   public FilterRegistrationBean<SessionFilter> xyzFilter() {
		   FilterRegistrationBean<SessionFilter> filterRegBean = new FilterRegistrationBean<>();
		   filterRegBean.setFilter(new SessionFilter());
		   filterRegBean.addUrlPatterns("/welcomePage/*","/EditYourProfile","/updateProfile","/getFriends/*","/ViewProfile");	
		   return filterRegBean;
	   }   
}
