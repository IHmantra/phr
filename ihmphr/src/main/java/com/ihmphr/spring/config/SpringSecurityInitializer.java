package com.ihmphr.spring.config;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;
import org.springframework.core.annotation.Order;

@Order(2)
public class SpringSecurityInitializer extends AbstractSecurityWebApplicationInitializer {

}
