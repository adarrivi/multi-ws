package com.adarrivi.multiws.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.adarrivi.multiws.api.config.ApiCoreContext;

@Configuration
@Import(value = { ApiCoreContext.class })
@ComponentScan(basePackages = { WebServiceCoreContext.SERVICE_PACKAGE })
public class WebServiceCoreContext {

    static final String SERVICE_PACKAGE = "com.adarrivi.multiws.ws";
}
