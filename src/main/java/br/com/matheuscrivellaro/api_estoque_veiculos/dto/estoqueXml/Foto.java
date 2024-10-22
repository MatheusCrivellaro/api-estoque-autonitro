package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Foto {
    @JacksonXmlProperty(localName = "NomeArquivo")
    private String nomeArquivo;
    @JacksonXmlProperty(localName = "URLArquivo")
    private String urlArquivo;
    @JacksonXmlProperty(localName = "Principal")
    private String principal;

}
