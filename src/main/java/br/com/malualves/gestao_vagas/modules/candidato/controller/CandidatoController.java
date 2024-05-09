package br.com.malualves.gestao_vagas.modules.candidato.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.malualves.gestao_vagas.modules.candidato.Candidato;
import br.com.malualves.gestao_vagas.modules.candidato.useCases.CreateCandidatoUseCase;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {
    @Autowired
    private CreateCandidatoUseCase createCandidatoUseCase;

    // Valid - valida os campos de acordo com o definido em Candidato
    @PostMapping("/")
    public ResponseEntity<Object> create(@Valid @RequestBody Candidato novoCandidato) {
        try {

            var resultado = this.createCandidatoUseCase.execute(novoCandidato);
            return ResponseEntity.ok().body(resultado);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());

        }
    }

}