package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.Veiculo;
import br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific.EmpresaNotFound;
import br.com.matheuscrivellaro.api_estoque_veiculos.repository.DadosEmpresaRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BasicsActionService {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private AutenticationService autenticationService;

    @Autowired
    private DadosEmpresaRepository empresaRepository;

    @Autowired
    private XmlService xmlService;

    public List<Veiculo> getEstoque(String username, String password, String cnpj) {
        var token = autenticationService.authenticate(username, password);
        return estoqueService.getExternalApiData(cnpj, token).getVeiculos().getVeiculo();
    }

    public List<Veiculo> getEstoque(String nome) {
        var dadosEmpresa = empresaRepository.findByNome(nome).orElseThrow(() -> new EmpresaNotFound("A empresa " + nome + " não foi encontrada"));
        var token = autenticationService.authenticate(dadosEmpresa.getUsername(), dadosEmpresa.getPassword());
        return estoqueService.getExternalApiData(dadosEmpresa.getCnpj(), token).getVeiculos().getVeiculo();
    }

    public List<Veiculo> getEstoqueXml(String url) throws JsonProcessingException {
        return xmlService.getVeiculosXml(url);
    }
}
