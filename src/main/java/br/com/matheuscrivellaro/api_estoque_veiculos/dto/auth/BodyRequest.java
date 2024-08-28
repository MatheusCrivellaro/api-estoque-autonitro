package br.com.matheuscrivellaro.api_estoque_veiculos.dto.auth;

public record BodyRequest(

        String usernameOrEmailAddress,
        String password

) { }
