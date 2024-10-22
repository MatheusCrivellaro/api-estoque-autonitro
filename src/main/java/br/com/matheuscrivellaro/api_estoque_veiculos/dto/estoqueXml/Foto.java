package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml;

import lombok.Data;

@Data
public class Foto {
    private String nomeArquivo;
    private String urlArquivo;
    private int principal;
}
