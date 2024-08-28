package br.com.matheuscrivellaro.api_estoque_veiculos.exception.response;

import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp,
        String message,
        String details
) { }
