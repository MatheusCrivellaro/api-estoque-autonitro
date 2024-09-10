package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.ResponseEstoqueInitial;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.ResultEstoque;
import br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific.GetStockException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatusCode;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class EstoqueService {

    private final WebClient.Builder webClientBuilder;
    private final Gson gson;

    @Autowired
    public EstoqueService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
        this.gson = new GsonBuilder().create();
    }

    public ResultEstoque getExternalApiData(String cnpj, String bearerToken) {
        String url = "http://api.autonitro.com.br/api/services/app/StoreSite/GetStoreSiteXmlByCNPJ?cnpj=" + cnpj;
        var response = webClientBuilder.build()
                .get()
                .uri(url)
                .header("Authorization", "Bearer " + bearerToken)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new GetStockException("Erro ao buscar Stock")))
                .bodyToMono(ResponseEstoqueInitial.class)
                .block();
        assert response != null;
        return gson.fromJson(response.getResult(), ResultEstoque.class);
    }
}
