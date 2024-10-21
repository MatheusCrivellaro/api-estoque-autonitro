package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.Veiculo;
import br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific.EmpresaNotFound;
import br.com.matheuscrivellaro.api_estoque_veiculos.repository.DadosEmpresaRepository;
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
    private FtpService ftpService;

    public List<Veiculo> getStock(String username, String password, String cnpj) {
        var token = autenticationService.authenticate(username, password);
        return estoqueService.getExternalApiData(cnpj, token).getVeiculos().getVeiculo();
    }

    public List<Veiculo> getStock(String nome) {
        var dadosEmpresa = empresaRepository.findByNome(nome).orElseThrow(() -> new EmpresaNotFound("A empresa " + nome + " não foi encontrada"));
        var token = autenticationService.authenticate(dadosEmpresa.getUsername(), dadosEmpresa.getPassword());
        return estoqueService.getExternalApiData(dadosEmpresa.getCnpj(), token).getVeiculos().getVeiculo();
    }

    public String getFtp(String remoteFilePath, String server, int port, String user, String password) throws IOException {
        return ftpService.getXml(remoteFilePath, server, port, user, password);
    }
}
