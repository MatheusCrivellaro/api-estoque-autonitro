package br.com.matheuscrivellaro.api_estoque_veiculos.dto.estoque;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Opcionais {
    private List<Opcional> Opcional;
}
