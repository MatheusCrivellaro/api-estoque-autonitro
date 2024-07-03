package br.com.stockhub.stockhub.service;

import br.com.stockhub.stockhub.dto.stock.Veiculo;
import br.com.stockhub.stockhub.dto.stock.VeiculoResumido;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class BasicsActionService {

    @Autowired
    private StockService stockService;

    public List<Veiculo> getStock(String cnpj, String token) throws IOException {
        return stockService.getStock(cnpj, token).getResult().getVeiculos().getVeiculo();
    }

    public List<VeiculoResumido> getStockResume(String cnpj, String bearerToken) throws IOException {
        var listaVeiculos = stockService.getStock(cnpj, bearerToken).getResult().getVeiculos().getVeiculo();
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
                        veiculo.getFotos()
                )
        ).toList();
    }
}
