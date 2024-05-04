package br.com.malualves.gestao_vagas.modules.empresa.repositorio;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import br.com.malualves.gestao_vagas.modules.empresa.entidades.Empresa;

public interface EmpresaRepositorio extends JpaRepository<Empresa, UUID> {
    Optional<Empresa> findByUsernameOrEmail(String username, String email);

}
