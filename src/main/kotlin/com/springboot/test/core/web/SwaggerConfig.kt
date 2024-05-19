package com.springboot.test.core.web

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springdoc.core.models.GroupedOpenApi
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class SwaggerConfig {
    @Bean
    fun customOpenAPI(): OpenAPI {
        return OpenAPI()
            .info(
                Info()
                    .title("springdoc-openapi")
                    .version("1.0")
                    .description("springdoc-openapi swagger-ui 화면입니다.")
            )
    }

    @Bean
    fun api(): GroupedOpenApi {
        val paths = arrayOf("/api/v1/**")
        val packagesToScan = arrayOf("com.springboot.test")
        return GroupedOpenApi.builder().group("springdoc-openapi")
            .pathsToMatch(*paths)
            .packagesToScan(*packagesToScan)
            .build()
    }
}