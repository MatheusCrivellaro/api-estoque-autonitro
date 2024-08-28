package br.com.matheuscrivellaro.api_estoque_veiculos.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
@Tag(name = "Health Controller", description = "Controller responsável pela saúde da aplicação")
public class HealthController {

    @Operation(
            description = "Retorna uma resposta HTTP 200 para garantir que a aplicação esta rodando corretamente no servidor",
            summary = "Retorna HTTP 200",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )
    @GetMapping
    public ResponseEntity<?> health() {
        return ResponseEntity.ok().build();
    }

    @Operation(
            description = "Retorna uma resposta HTTP 200 junto com um teste visual, retornando a frase Hello World !",
            summary = "Teste Hello World",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )
    @GetMapping("/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Hello World !");
    }
}
