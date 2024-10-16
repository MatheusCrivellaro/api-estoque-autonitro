package br.com.matheuscrivellaro.api_estoque_veiculos.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder()
                .codecs(config -> config.defaultCodecs().maxInMemorySize(10 * 1024 * 1024 ));
    }

}
