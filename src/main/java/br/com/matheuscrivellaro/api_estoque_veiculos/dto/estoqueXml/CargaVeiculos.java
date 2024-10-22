package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoqueXml;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CargaVeiculos {
    @JacksonXmlProperty(localName = "Veiculos")
    private Veiculos veiculos;

}
