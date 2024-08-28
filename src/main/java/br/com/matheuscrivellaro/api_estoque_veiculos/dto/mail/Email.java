package br.com.matheuscrivellaro.api_estoque_veiculos.dto.mail;

public record Email(
        String to,
        String subject,
        String text
) {
}
