package br.gov.sp.fatec.bptopics.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.sp.fatec.bptopics.entity.Glossario;
import br.gov.sp.fatec.bptopics.repository.GlossarioRepository;

@Service
public class GlossarioServiceImpl implements GlossarioService {

    @Autowired
    GlossarioRepository glossarioRepository;

    @Override
    public List<Glossario> buscarPorTermo(String termo) {
        List<Glossario> glossario = glossarioRepository.findByTermoContains(termo);

        return glossario;
    }
    
}
