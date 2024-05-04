package br.com.malualves.gestao_vagas.modules.empresa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.malualves.gestao_vagas.modules.candidato.Candidato;
import br.com.malualves.gestao_vagas.modules.empresa.entidades.Empresa;
import br.com.malualves.gestao_vagas.modules.empresa.useCase.CreateEmpresaUseCase;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
    @Autowired
    private CreateEmpresaUseCase createEmpresaUseCase;

    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Empresa novaEmpresa) {
        try {

            var resultado = this.createEmpresaUseCase.execute(novaEmpresa);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

}
