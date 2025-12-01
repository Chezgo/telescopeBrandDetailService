package com.example.telescopeBrandDetailService.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI telescopeBrandDetailOpenAPI() {
        SecurityScheme securityScheme = new SecurityScheme()
                .type(SecurityScheme.Type.HTTP)
                .scheme("bearer")
                .bearerFormat("JWT")
                .description("Введите JWT-токен в формате: <code>Bearer eyJhbGciOi...</code>");

        SecurityRequirement securityRequirement = new SecurityRequirement()
                .addList("bearerAuth");

        return new OpenAPI()
                .info(new Info()
                        .title("Telescope Brand Detail Service API")
                        .description("""
                    API для управления брендами деталей телескопов.
                    <br><br>
                    <b>Авторизация:</b> Все эндпоинты защищены Keycloak.
                    Для использования "Execute" введите JWT-токен через кнопку "Authorize".
                    """)
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Dmitriy")
                                .email("dima.chezganov@mail.ru"))
                )
                .addServersItem(new Server()
                        .url("https://api.our-galaxy.space/telescope-brand-detail")
                        .description("Production API через Gravitee Gateway")
                )
                .components(new Components()
                        .addSecuritySchemes("bearerAuth", securityScheme)
                )
                .addSecurityItem(securityRequirement);
    }
}