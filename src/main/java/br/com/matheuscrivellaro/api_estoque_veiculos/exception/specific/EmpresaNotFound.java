package br.com.matheuscrivellaro.api_estoque_veiculos.exception.specific;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class EmpresaNotFound extends RuntimeException {
    public EmpresaNotFound(String message) {
        super(message);
    }
}
