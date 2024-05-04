package br.com.malualves.gestao_vagas.modules.candidato;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidatoRepositorio extends JpaRepository<Candidato, UUID> { // RECEBO A ENTIDADE E O TIPO DA CHAVE
    // validar dados, para evitar duplicação
    // procurar um candidato com o username e email
    Optional<Candidato> findByUsernameOrEmail(String username, String email);

}
