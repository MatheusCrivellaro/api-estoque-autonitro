package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque;

import lombok.Data;

@Data
public class ResponseEstoqueInitial {
    private String result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
}
