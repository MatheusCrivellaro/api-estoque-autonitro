package br.com.stockhub.stockhub.controller;

import br.com.stockhub.stockhub.dto.stock.VeiculoResumido;
import br.com.stockhub.stockhub.service.BasicsActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stock")
@EnableCaching
public class StockController {

    @Autowired
    private BasicsActionService actionService;

    @Cacheable("carros")
    @GetMapping("/{username}/{password}/{cnpj}")
    public ResponseEntity<List<VeiculoResumido>> findAll(@PathVariable String username, @PathVariable String password, @PathVariable String cnpj) {
        return ResponseEntity.ok(
                actionService.getStock(username, password, cnpj)
        );
    }
}
