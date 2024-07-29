package br.com.stockhub.stockhub.dto.auth;

public record BodyRequest(

        String usernameOrEmailAddress,
        String password

) { }
