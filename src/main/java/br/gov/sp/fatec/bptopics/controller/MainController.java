package br.gov.sp.fatec.bptopics.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
    
    @GetMapping
    public String hello() {
        return "Projeto de Tópicos. Prof Mineda!";
    }
}
