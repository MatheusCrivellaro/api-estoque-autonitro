package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class VeiculoResumido {

    private String Codigo;
    private String PlacaVeiculo;
    private String Marca;
    private String Modelo;
    private String Versao;
    private String Combustivel;
    private String Cambio;
    private String Cor;
    private String KM;
    private String Carroceria;
    private String PrecoVenda;
    private Opcionais Opcionais;
    private Fotos Fotos;

}
