package br.com.matheuscrivellaro.api_estoque_veiculos.controller;

import br.com.matheuscrivellaro.api_estoque_veiculos.dto.mail.Email;
import br.com.matheuscrivellaro.api_estoque_veiculos.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mail")
public class MailController {

    @Autowired
    private MailService mailService;

    @PostMapping
    public ResponseEntity<?> sendMail(@RequestBody Email email) {
        mailService.sendMail(email.to(), email.subject(), email.text());
        return ResponseEntity.ok().build();
    }

}
