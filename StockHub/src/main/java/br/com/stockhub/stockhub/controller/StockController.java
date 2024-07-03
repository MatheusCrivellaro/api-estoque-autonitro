package br.com.stockhub.stockhub.controller;

import br.com.stockhub.stockhub.dto.stock.Veiculo;
import br.com.stockhub.stockhub.dto.stock.VeiculoResumido;
import br.com.stockhub.stockhub.service.BasicsActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    private BasicsActionService actionService;

    @GetMapping("/allComplete")
    public ResponseEntity<List<Veiculo>> findAllComplete(@RequestHeader("Authorization") String token, @RequestHeader("cnpj") String cnpj) throws IOException {
        return ResponseEntity.ok(
                actionService.getStock(cnpj, token)
        );
    }

    @GetMapping("/all")
    public ResponseEntity<List<VeiculoResumido>> findAll(@RequestHeader("Authorization") String token, @RequestHeader("cnpj") String cnpj) throws IOException {
        return ResponseEntity.ok(
                actionService.getStockResume(cnpj, token)
        );
    }
}
