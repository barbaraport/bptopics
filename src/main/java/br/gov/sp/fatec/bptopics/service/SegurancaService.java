package br.gov.sp.fatec.bptopics.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import br.gov.sp.fatec.bptopics.entity.Usuario;

public interface SegurancaService extends UserDetailsService {

    public Usuario novoUsuario(Usuario usuario);

    public Usuario novoUsuario(String nome, String senha);

    public Usuario novoUsuario(String nome, String senha, String autorizacao);

    public List<Usuario> todosUsuarios();

    public Usuario buscarPorId(Long id);
}