package br.gov.sp.fatec.bptopics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.bptopics.entity.Glossario;
import br.gov.sp.fatec.bptopics.service.GlossarioService;

@CrossOrigin
@RestController
@RequestMapping(value = "/glossario")
public class GlossarioController {

    @Autowired
    GlossarioService glossarioService;
    
    @GetMapping(value = "/{termo}")
    public List<Glossario> buscarPorTermo(@PathVariable(name = "termo") String termo){

        return glossarioService.buscarPorTermo(termo);
    }
}
