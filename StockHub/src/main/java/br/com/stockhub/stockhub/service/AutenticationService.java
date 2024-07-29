package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.auth.AutonitroTokenResponse;
import br.com.stockhub.stockhub.dto.auth.BodyRequest;
import br.com.stockhub.stockhub.exception.specific.GetStockException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class AutenticationService {

    private final WebClient.Builder webClientBuilder;

    @Autowired
    public AutenticationService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public String authenticate(String username, String password) {
        String url = "http://api.autonitro.com.br/api/TokenAuth/Authenticate";
        var body = new BodyRequest(username, password);
        var response = webClientBuilder.build()
                .post()
                .uri(url)
                .bodyValue(body)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new GetStockException("Erro ao buscar Stock")))
                .bodyToMono(AutonitroTokenResponse.class)
                .block();
        assert response != null;
        return response.getResult().getAccessToken();
    }
}
