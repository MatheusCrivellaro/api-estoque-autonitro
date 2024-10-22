package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.*;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml.CargaVeiculos;
import br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific.GetStockException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class XmlService {

    private final WebClient webClient;

    public XmlService(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("https://api.exemplo.com").build();
    }

    public String getXml(String uri) {
        return webClient.get()
                .uri(uri) // substitua pelo seu endpoint
                .accept()
                .retrieve()
                .bodyToMono(String.class)
                .block();
    }

    public List<Veiculo> getVeiculosXml(String uri) throws JsonProcessingException {
        var response = getXml(uri);
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.readValue(response, CargaVeiculos.class).getVeiculos().getVeiculo();
    }

}
