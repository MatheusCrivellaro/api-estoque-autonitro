package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.stock.ResponseStockInitial;
import br.com.stockhub.stockhub.dto.stock.ResultStock;
import br.com.stockhub.stockhub.exception.specific.GetStockException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class StockService {

    private final WebClient.Builder webClientBuilder;
    private final Gson gson;

    @Autowired
    public StockService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
        this.gson = new GsonBuilder().create();
    }

    public ResultStock getExternalApiData(String cnpj, String bearerToken) {
        String url = "http://api.autonitro.com.br/api/services/app/StoreSite/GetStoreSiteXmlByCNPJ?cnpj=" + cnpj;
        var response = webClientBuilder.build()
                .get()
                .uri(url)
                .header("Authorization", "Bearer " + bearerToken)
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, clientResponse -> Mono.error(new GetStockException("Erro ao buscar Stock")))
                .bodyToMono(ResponseStockInitial.class)
                .block();
        assert response != null;
        return gson.fromJson(response.getResult(), ResultStock.class);
    }
}
