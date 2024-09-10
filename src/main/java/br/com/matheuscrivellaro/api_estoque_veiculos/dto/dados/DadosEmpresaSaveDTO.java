package br.com.matheuscrivellaro.api_estoque_veiculos.dto.dados;

public record DadosEmpresaSaveDTO(
        Long id,
        String nome,
        String username,
        String password,
        String cnpj
) {
}
