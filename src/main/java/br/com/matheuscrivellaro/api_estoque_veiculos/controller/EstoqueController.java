package br.com.matheuscrivellaro.api_estoque_veiculos.controller;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque.Veiculo;
import br.com.matheuscrivellaro.api_estoque_veiculos.service.BasicsActionService;
import com.fasterxml.jackson.core.JsonProcessingException;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/estoque")
@EnableCaching
@Tag(name = "Estoque Controller", description = "Controller responsável pela coleta de estoque")
public class EstoqueController {

    @Autowired
    private BasicsActionService actionService;

    @Operation(
            description = "Retorna uma lista de veículos, junto com seus principais dados",
            summary = "Lista veículos em estoque",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200"),
                    @ApiResponse(description = "Internal Server Error", responseCode = "500"),
                    @ApiResponse(description = "Unauthorized", responseCode = "401")
            }
    )
    @Cacheable(value = "estoque_cache")
    @GetMapping(value = "/autonitro/{username}/{password}/{cnpj}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Veiculo>> findAllByAuth(@PathVariable String username, @PathVariable String password, @PathVariable String cnpj) {
        return ResponseEntity.ok(
                actionService.getEstoque(username, password, cnpj)
        );
    }

    @Cacheable(value = "estoque_nome_cache")
    @GetMapping(value = "/{name}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Veiculo>> findAllByName(@PathVariable String name) {
        return ResponseEntity.ok(
                actionService.getEstoque(name)
        );
    }

    @GetMapping("/xml")
    public ResponseEntity<List<Veiculo>> findAllByXml(@RequestParam String url) throws JsonProcessingException {
        return ResponseEntity.ok(actionService.getEstoqueXml(url));
    }
}
