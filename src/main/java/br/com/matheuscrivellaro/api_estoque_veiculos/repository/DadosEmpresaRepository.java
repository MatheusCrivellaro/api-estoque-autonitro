package br.com.matheuscrivellaro.api_estoque_veiculos.repository;

import br.com.matheuscrivellaro.api_estoque_veiculos.domain.DadosEmpresa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DadosEmpresaRepository extends JpaRepository<DadosEmpresa, Long> {
    
    Optional<DadosEmpresa> findByNome(String nome);
    
}
