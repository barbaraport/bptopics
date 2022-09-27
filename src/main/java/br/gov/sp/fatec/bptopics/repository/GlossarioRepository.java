package br.gov.sp.fatec.bptopics.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bptopics.entity.Glossario;

public interface GlossarioRepository  extends JpaRepository<Glossario, Long>{
    
    public List<Glossario> findByTermoContains(String termo);
}
