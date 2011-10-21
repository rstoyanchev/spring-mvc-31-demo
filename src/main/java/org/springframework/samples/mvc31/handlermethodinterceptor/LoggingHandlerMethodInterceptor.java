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

package org.springframework.samples.mvc31.handlermethodinterceptor;

import java.lang.annotation.Annotation;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.LocalVariableTableParameterNameDiscoverer;
import org.springframework.core.MethodParameter;
import org.springframework.core.ParameterNameDiscoverer;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoggingHandlerMethodInterceptor extends HandlerInterceptorAdapter {

	private static Logger logger = LoggerFactory.getLogger(LoggingHandlerMethodInterceptor.class);

	private final ParameterNameDiscoverer parameterNameDiscoverer = new LocalVariableTableParameterNameDiscoverer();

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		if (handler instanceof HandlerMethod) {
			logger.debug(asString((HandlerMethod) handler));
		}
		
		return true;
	}

	private String asString(HandlerMethod handlerMethod) {
		StringBuilder sb = new StringBuilder();
		sb.append("\nController:\n").append(handlerMethod.getBeanType().getSimpleName());
		sb.append("\nMethod:\n");
		sb.append(handlerMethod.getMethod().getReturnType().getSimpleName()).append(" ");
		sb.append(handlerMethod.getMethod().getName()).append("(");
		for (MethodParameter param : handlerMethod.getMethodParameters()) {
			param.initParameterNameDiscovery(this.parameterNameDiscoverer);
			for (Annotation annotation : param.getParameterAnnotations()) {
				sb.append(annotation).append(" ");
			}
			sb.append(param.getParameterType().getSimpleName()).append(" ");
			sb.append(param.getParameterName());
			if (param.getParameterIndex() < handlerMethod.getMethodParameters().length - 1) {
				sb.append(" ");
			}
		}
		sb.append(")\n");
		return sb.toString();
	}
	
}
