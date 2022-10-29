package com.hyunec.config

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import io.swagger.v3.oas.models.servers.Server
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import java.time.LocalDateTime

@Configuration
class OpenAPIConfig {
    @Bean
    fun openAPI(): OpenAPI {
        return OpenAPI()
            .info(Info().title("Emergency Alert System").version(LocalDateTime.now().toString()))
            .servers(listOf((Server().url("http://localhost:8080"))))
    }
}
