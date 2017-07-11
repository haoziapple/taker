package com.haozi.taker.service;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;

import com.fzrj.intf.security.filter.IntfVerifyFilter;
import com.haozi.taker.service.common.constant.ControllerConst;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application
{
	public static void main(String[] args)
	{
		ApplicationContext ctx = SpringApplication.run(Application.class, args);

		String[] beanNames = ctx.getBeanDefinitionNames();
		Arrays.sort(beanNames);
		for (String beanName : beanNames)
		{
			System.out.println(beanName);
		}
	}
	
	@Bean
	public FilterRegistrationBean filterRegistration()
	{

		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new IntfVerifyFilter());
		registration.addUrlPatterns(ControllerConst.API_PRE + "/*");
		registration.addInitParameter("passIP", 
//				"");
		 "0:0:0:0:0:0:0:1|127.0.0.1|10.108.26.11|10.108.26.9|10.108.26.61|192.168.101.15|192.168.102.62|10.108.26.246");
		registration.setName("intfVerifyFilter");
		registration.setOrder(1);
		return registration;
	}
}
