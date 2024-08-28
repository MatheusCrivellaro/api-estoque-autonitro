package br.com.matheuscrivellaro.api_estoque_veiculos.service;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.Veiculo;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.VeiculoResumido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BasicsActionService {

    @Autowired
    private StockService stockService;

    @Autowired
    private AutenticationService autenticationService;

    public List<VeiculoResumido> getStock(String username, String password, String cnpj) {
        var token = autenticationService.authenticate(username, password);
        return getStockResume(cnpj, token);
    }

    @Deprecated
    public List<Veiculo> getStockAll(String username, String password, String cnpj) {
        var token = autenticationService.authenticate(username, password);
        return stockService.getExternalApiData(cnpj, token).getVeiculos().getVeiculo();
    }
    
    public List<VeiculoResumido> getStockResume(String cnpj, String bearerToken) {
        var listaVeiculos = stockService.getExternalApiData(cnpj, bearerToken).getVeiculos().getVeiculo();
        return listaVeiculos.stream().map(veiculo ->
                new VeiculoResumido(
                        veiculo.getCodigo(),
                        veiculo.getPlacaVeiculo(),
                        veiculo.getMarca(),
                        veiculo.getModelo(),
                        veiculo.getVersao(),
                        veiculo.getCombustivel(),
                        veiculo.getCambio(),
                        veiculo.getCor(),
                        veiculo.getKM(),
                        veiculo.getCarroceria(),
                        veiculo.getPrecoVenda(),
                        veiculo.getOpcionais(),
                        veiculo.getFotos(),
                        veiculo.getUsadoNovo(),
                        veiculo.getAnoModelo(),
                        veiculo.getAnoFabricacao(),
                        veiculo.getTipoVeiculo(),
                        veiculo.getBlindado(),
                        veiculo.getDestaque()
                )
        ).toList();
    }
}
