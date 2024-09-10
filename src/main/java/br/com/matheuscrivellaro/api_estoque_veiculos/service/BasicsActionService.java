package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.domain.DadosEmpresa;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.dados.DadosEmpresaDTO;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.dados.DadosEmpresaSaveDTO;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.Veiculo;
import br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific.EmpresaNotFound;
import br.com.matheuscrivellaro.api_estoque_veiculos.repository.DadosEmpresaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicsActionService {

    @Autowired
    private EstoqueService estoqueService;

    @Autowired
    private AutenticationService autenticationService;

    @Autowired
    private DadosEmpresaRepository empresaRepository;

    @CachePut("estoqueDados")
    public List<Veiculo> getStock(String username, String password, String cnpj) {
        var token = autenticationService.authenticate(username, password);
        return estoqueService.getExternalApiData(cnpj, token).getVeiculos().getVeiculo();
    }

    @CachePut("estoqueNome")
    public List<Veiculo> getStock(String nome) {
        var dadosEmpresa = empresaRepository.findByNome(nome).orElseThrow(() -> new EmpresaNotFound("A empresa " + nome + " não foi encontrada"));
        var token = autenticationService.authenticate(dadosEmpresa.getUsername(), dadosEmpresa.getPassword());
        return estoqueService.getExternalApiData(dadosEmpresa.getCnpj(), token).getVeiculos().getVeiculo();
    }

    public DadosEmpresaSaveDTO insertDadosEmpresa(DadosEmpresaDTO dados) {
        var dadosEntity = new DadosEmpresa();
        dadosEntity.setNome(dados.nome());
        dadosEntity.setUsername(dados.username());
        dadosEntity.setPassword(dados.password());
        dadosEntity.setCnpj(dados.cnpj());
        var newEntity = empresaRepository.save(dadosEntity);
        return new DadosEmpresaSaveDTO(
                newEntity.getId(),
                newEntity.getNome(),
                newEntity.getUsername(),
                newEntity.getPassword(),
                newEntity.getCnpj()
        );
    }
}
