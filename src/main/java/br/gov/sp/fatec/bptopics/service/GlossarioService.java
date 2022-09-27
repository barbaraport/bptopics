package br.gov.sp.fatec.bptopics.service;

import java.util.List;

import br.gov.sp.fatec.bptopics.entity.Glossario;

public interface GlossarioService {
    
    public List<Glossario> buscarPorTermo(String termo);
}
