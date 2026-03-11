package com.soporte.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI soporteApiConfig() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de Soporte Técnico")
                        .description("API RESTful para registrar, consultar, actualizar y eliminar solicitudes de soporte técnico de clientes de la empresa.")
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Grupo 08 - Equipo Backend")
                                .email("soporte@empresa.com")
                                .url("https://github.com/JairoAranyaH/soporte-tecnico")
                        )
                        .license(new License()
                                .name("Licencia MIT")
                                .url("https://opensource.org/licenses/MIT")
                        ));
    }
}
