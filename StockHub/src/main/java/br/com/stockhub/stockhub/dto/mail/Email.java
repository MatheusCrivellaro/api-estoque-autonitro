package br.com.stockhub.stockhub.dto.mail;

public record Email(
        String to,
        String subject,
        String text
) {
}
