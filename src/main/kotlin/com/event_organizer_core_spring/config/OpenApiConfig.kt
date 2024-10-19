package com.event_organizer_core_spring.config

import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.info.Contact
import io.swagger.v3.oas.models.OpenAPI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class OpenApiConfig {

    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("Event Organizer API")
                    .version("1.0.0")
                    .description("API documentation for Event Organizer Application")
                    .contact(
                        Contact()
                            .name("Your Name")
                            .url("http://www.example.com")
                            .email("your.email@example.com")
                    )
            )
    }
}
