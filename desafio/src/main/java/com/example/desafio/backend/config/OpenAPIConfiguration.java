package com.example.desafio.backend.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfiguration {

        @Bean
        public OpenAPI configOpenAPI() {
            return new OpenAPI()
                    .info(new Info()
                            .title("Contratação de Seguros")
                            .description("API para gerenciamento de clientes e contratação de seguros"))
                    ;
        }
    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder()
                .group("public")
                .pathsToMatch("/cliente/**","/plano/**")
                .build();
    }
    }

