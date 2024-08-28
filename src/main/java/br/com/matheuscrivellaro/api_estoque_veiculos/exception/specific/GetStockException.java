package br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class GetStockException extends RuntimeException{

    public GetStockException(String message) {
        super(message);
    }
}
