package br.com.matheuscrivellaro.api_estoque_veiculos.dto.stock;

import lombok.Data;

@Data
public class ResponseStockInitial {
    private String result;
    private Object targetUrl;
    private boolean success;
    private Object error;
    private boolean unAuthorizedRequest;
    private boolean __abp;
}
