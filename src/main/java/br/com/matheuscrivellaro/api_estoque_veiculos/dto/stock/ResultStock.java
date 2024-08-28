package br.com.matheuscrivellaro.api_estoque_veiculos.dto.stock;

import lombok.Data;

@Data
public class ResultStock {

    private String LogoUrl;
    private String Grupo;
    private String Email;
    private String RazaoSocial;
    private String NomeFantasia;
    private String Cnpj;
    private String Endereco;
    private String WhatsApp;
    private String Telefone;
    private String DataPublicacao;
    private String HashPaidTraffic;
    private String Ramal1;
    private Veiculos Veiculos;

}
