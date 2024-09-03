package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.Veiculo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicsActionService {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private AutenticationService autenticationService;

    public List<Veiculo> getStock(String username, String password, String cnpj) {
        var token = autenticationService.authenticate(username, password);
        return estoqueService.getExternalApiData(cnpj, token).getVeiculos().getVeiculo();
    }
}
