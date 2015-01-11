package com.adarrivi.multiws.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(value = { WebServiceCoreContext.class })
public class WebServiceContext {

}
