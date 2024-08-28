package br.com.matheuscrivellaro.api_estoque_veiculos.controller;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.mail.Email;
import br.com.matheuscrivellaro.api_estoque_veiculos.service.MailService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
@Tag(name = "Mail Controller", description = "Controller responsável pelo envio de emails")
public class MailController {

    @Autowired
    private MailService mailService;

    @Operation(
            description = "Envia um email com os dados fornecidos no body da requisição para o email informado",
            summary = "Envia Email",
            responses = {
                    @ApiResponse(description = "Ok", responseCode = "200")
            }
    )
    @PostMapping
    public ResponseEntity<?> sendMail(@RequestBody Email email) {
        mailService.sendMail(email.to(), email.subject(), email.text());
        return ResponseEntity.ok().build();
    }

}
