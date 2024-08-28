package br.com.stockhub.stockhub.controller;

import br.com.stockhub.stockhub.dto.mail.Email;
import br.com.stockhub.stockhub.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
