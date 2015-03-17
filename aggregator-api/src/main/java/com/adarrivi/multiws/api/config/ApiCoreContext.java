package com.adarrivi.multiws.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = { ApiCoreContext.SERVICE_PACKAGE })
public class ApiCoreContext {

	static final String SERVICE_PACKAGE = "com.adarrivi.multiws.api";

}
