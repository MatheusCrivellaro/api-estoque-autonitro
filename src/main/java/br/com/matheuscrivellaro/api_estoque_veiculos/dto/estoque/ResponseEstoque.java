package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseEstoque {
    private ResultEstoque result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
}