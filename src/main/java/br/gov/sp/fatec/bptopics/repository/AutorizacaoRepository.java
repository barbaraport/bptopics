package br.gov.sp.fatec.bptopics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bptopics.entity.Autorizacao;

public interface AutorizacaoRepository extends JpaRepository<Autorizacao, Long> {
    
    public Autorizacao findByNome(String nome);
}
