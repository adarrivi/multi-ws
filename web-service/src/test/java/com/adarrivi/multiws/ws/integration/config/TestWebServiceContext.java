package com.adarrivi.multiws.ws.integration.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import com.adarrivi.multiws.config.WebRestConfiguration;
import com.adarrivi.multiws.config.WebServiceCoreContext;

@Configuration
@PropertySource("classpath:ws.properties")
@Import(value = { WebRestConfiguration.class, WebServiceCoreContext.class })
public class TestWebServiceContext {

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeHolderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
