package br.com.matheuscrivellaro.api_estoque_veiculos.controller;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.dados.DadosEmpresaDTO;
import br.com.matheuscrivellaro.api_estoque_veiculos.dto.dados.DadosEmpresaSaveDTO;
import br.com.matheuscrivellaro.api_estoque_veiculos.service.BasicsActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/dados")
public class DadosController {

    @Autowired
    private BasicsActionService actionService;

    @PostMapping
    public ResponseEntity<DadosEmpresaSaveDTO> insertDados(@RequestBody DadosEmpresaDTO dados) {
        var newDado = actionService.insertDadosEmpresa(dados);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newDado.id())
                .toUri();
        return ResponseEntity.created(location).body(newDado);
    }

}
