package br.com.malualves.gestao_vagas.modules.empresa.repositorio;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.malualves.gestao_vagas.modules.empresa.entidades.Vaga;

public interface VagaRepositorio extends JpaRepository<Vaga, UUID> {

}
