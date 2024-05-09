package br.com.malualves.gestao_vagas.modules.empresa.useCase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.malualves.gestao_vagas.exceptions.EmpresaFoundException;
import br.com.malualves.gestao_vagas.modules.empresa.entidades.Empresa;
import br.com.malualves.gestao_vagas.modules.empresa.repositorio.EmpresaRepositorio;

@Service
public class CreateEmpresaUseCase {
    @Autowired
    private EmpresaRepositorio empresaRepositorio;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Empresa execute(Empresa novaEmpresa) {
        this.empresaRepositorio.findByUsernameOrEmail(novaEmpresa.getUsername(), novaEmpresa.getEmail())
                .ifPresent((empr) -> {
                    throw new EmpresaFoundException();
                });
        var password = passwordEncoder.encode(novaEmpresa.getPassword());
        novaEmpresa.setPassword(password);

        return this.empresaRepositorio.save(novaEmpresa);

    }

}
