package com.allan.appcontrolecontatos.config;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class SwaggerConfig {
	
	@Bean
    public GroupedOpenApi publicApi() {

        return GroupedOpenApi.builder()
                .group("Controle de Contatos")
                .pathsToMatch("/**")
                .build();

    }

    @Bean
    public OpenAPI publicAPISettings() {

        return new OpenAPI()
                .info(new Info().title("Controle de Contatos")
                        .description("Sistema de controle de contatos.")
                        .version("v0.0.1")
                        .license(new License().name("Spring Doc").url("http://springdoc.org")))
               
                .externalDocs(new ExternalDocumentation());

    }
    
   
}
