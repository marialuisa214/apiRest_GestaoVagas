package br.com.malualves.gestao_vagas.modules.empresa.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.malualves.gestao_vagas.exceptions.EmpresaFoundException;
import br.com.malualves.gestao_vagas.modules.empresa.entidades.Vaga;
import br.com.malualves.gestao_vagas.modules.empresa.repositorio.VagaRepositorio;

@Service
public class CreateVagaUseCase {
    @Autowired
    public VagaRepositorio vagaRepositorio;

    public Vaga execute(Vaga novaVaga) {
        return this.vagaRepositorio.save(novaVaga);

    }

}
