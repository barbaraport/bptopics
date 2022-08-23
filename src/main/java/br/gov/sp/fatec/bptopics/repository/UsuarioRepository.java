package br.gov.sp.fatec.bptopics.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.sp.fatec.bptopics.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
    
}
