package br.com.malualves.gestao_vagas.modules.candidato.useCases;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.malualves.gestao_vagas.exceptions.UserFoundException;
import br.com.malualves.gestao_vagas.modules.candidato.Candidato;
import br.com.malualves.gestao_vagas.modules.candidato.CandidatoRepositorio;

@Service // camada que mostra, gerencia, a regra de negocio
public class CreateCandidatoUseCase {

    @Autowired
    private CandidatoRepositorio candidatoRepositorio;

    public Candidato execute(Candidato novoCandidato) {
        this.candidatoRepositorio.findByUsernameOrEmail(novoCandidato.getUsername(), novoCandidato.getEmail())
                .ifPresent((user) -> {
                    throw new UserFoundException();
                });

        return this.candidatoRepositorio.save(novoCandidato);

    }

}
