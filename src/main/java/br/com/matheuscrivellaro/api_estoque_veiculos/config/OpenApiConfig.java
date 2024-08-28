package br.com.matheuscrivellaro.api_estoque_veiculos.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition
@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI apiEstoque() {
        return new OpenAPI()
                .info(new Info()
                        .title("API de estoque de concessionárias")
                        .description("API que retorna os dados de estoque de veiculos de uma concessionária")
                        .version("v0.0.1")
                        .license(new License()
                                .name("Apache 2.0")
                                .url("https://github.com/MatheusCrivellaro/api-estoque-veiculos")
                        )
                );
    }

}
