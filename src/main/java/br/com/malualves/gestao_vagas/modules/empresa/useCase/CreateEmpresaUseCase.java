package br.com.malualves.gestao_vagas.modules.empresa.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.malualves.gestao_vagas.exceptions.EmpresaFoundException;
import br.com.malualves.gestao_vagas.modules.empresa.entidades.Empresa;
import br.com.malualves.gestao_vagas.modules.empresa.repositorio.EmpresaRepositorio;

@Service
public class CreateEmpresaUseCase {
    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    public Empresa execute(Empresa novaEmpresa) {
        this.empresaRepositorio.findByUsernameOrEmail(novaEmpresa.getUsername(), novaEmpresa.getEmail())
                .ifPresent((empr) -> {
                    throw new EmpresaFoundException();
                });

        return this.empresaRepositorio.save(novaEmpresa);

    }

}
