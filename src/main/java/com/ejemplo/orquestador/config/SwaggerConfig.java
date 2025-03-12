package com.ejemplo.orquestador.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Swagger configuration.
 */
@Configuration
public class SwaggerConfig {

    /**
     * Configures product api.
     *
     * @return GroupedOpenApi
     */

    @Bean
    public GroupedOpenApi productApi() {
        return GroupedOpenApi.builder().group("bs").packagesToScan("com.ejemplo").build();
    }
}
