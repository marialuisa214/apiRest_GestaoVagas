package br.com.malualves.gestao_vagas.modules.empresa.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.malualves.gestao_vagas.modules.empresa.entidades.Vaga;
import br.com.malualves.gestao_vagas.modules.empresa.useCase.CreateVagaUseCase;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/vaga")
public class VagaController {
    @Autowired
    private CreateVagaUseCase createVagaUseCase;

    @PostMapping("/")
    public Vaga create(@Valid @RequestBody Vaga novaVaga) {
        return this.createVagaUseCase.execute(novaVaga);
    }

}
