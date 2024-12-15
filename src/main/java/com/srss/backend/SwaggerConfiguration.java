package com.srss.backend;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfiguration {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                    .title("Sistem Rumah Sakit Sederhana API")
                    .version("1.0.0")
                    .description("API documentation for the hospital management system backend"));
    }
}