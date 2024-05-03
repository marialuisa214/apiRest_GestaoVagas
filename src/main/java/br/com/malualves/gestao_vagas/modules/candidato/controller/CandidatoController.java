package br.com.malualves.gestao_vagas.modules.candidato.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
@RequestMapping("/candidato")
public class CandidatoController{
    

    @PostMapping("/")
    public void  create(){

    }

}