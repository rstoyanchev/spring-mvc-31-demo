/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.samples.mvc31.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.samples.mvc31.crudcontroller.AccountConverter;
import org.springframework.samples.mvc31.exceptionhandler.GlobalExceptionHandler;
import org.springframework.samples.mvc31.exceptionhandler.mvc.ExtendedExceptionHandlerExceptionResolver;
import org.springframework.samples.mvc31.handlermethodinterceptor.LoggingHandlerMethodInterceptor;
import org.springframework.samples.mvc31.requestcondition.mvc.ExtendedRequestMappingHandlerMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

/**
 * Spring MVC Java-based configuration.
 * 
 * <p>Extends directly from WebMvcConfigurationSupport in order to plug in sub-classes 
 * of Spring MVC infrastructure components like {@code RequestMappingHandlerMapping},
 * {@code RequestMappingHandlerAdapter}, etc. 
 * 
 * <p>Typically extending from {@link WebMvcConfigurerAdapter} and adding 
 * {@code @EnableWebMvc} is sufficient. 
 * 
 */
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
		registry.addViewController("/login").setViewName("login");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}
	
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	// Configuration for CRUD controller
	// See ~.crudcontroller
	
	@Override
	protected void addFormatters(FormatterRegistry registry) {
		AccountConverter accountConverter = new AccountConverter(this.applicationConfig.accountManager());
		registry.addConverter(accountConverter);
	}
	
	// Configuration for the interceptor logging HandlerMethod information
	// See ~.handlermethodinterceptor

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggingHandlerMethodInterceptor());
	}

	// Configuration for custom @RequestMapping condition
	// See ~.requestcondition package

	@Override
	@Bean
	public RequestMappingHandlerMapping requestMappingHandlerMapping() {
		RequestMappingHandlerMapping handlerMapping = new ExtendedRequestMappingHandlerMapping();
		handlerMapping.setOrder(0);
		handlerMapping.setInterceptors(getInterceptors());
		return handlerMapping;
	}

	// Configuration for "global" @ExceptionHandler methods
	// See ~.exceptionhandler package
	
	@Override
	public void configureHandlerExceptionResolvers(List<HandlerExceptionResolver> exceptionResolvers) {
		exceptionResolvers.add(customExceptionResolver());
	}

	@Bean 
	public ExceptionHandlerExceptionResolver customExceptionResolver() {
		ExtendedExceptionHandlerExceptionResolver exceptionResolver = new ExtendedExceptionHandlerExceptionResolver();
		exceptionResolver.setExceptionHandler(new GlobalExceptionHandler());
		return exceptionResolver;
	}
	
}
