package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Foto {
    private String Nome;
    private String URI;
    private String Sequencia;
}
