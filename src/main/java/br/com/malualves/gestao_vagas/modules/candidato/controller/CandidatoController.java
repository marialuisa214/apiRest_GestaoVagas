package br.com.malualves.gestao_vagas.modules.candidato.controller;

import org.springframework.web.bind.annotation.RestController;

import br.com.malualves.gestao_vagas.modules.candidato.Candidato;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/candidato")
public class CandidatoController {

    // Valid - valida os campos de acordo com o definido em Candidato
    @PostMapping("/")
    public void create(@Valid @RequestBody Candidato candidato) {
        System.out.println("Candidato");
        System.out.println(candidato.getNome());
    }

}