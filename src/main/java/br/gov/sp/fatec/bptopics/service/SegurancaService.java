package br.gov.sp.fatec.bptopics.service;

import java.util.List;

import br.gov.sp.fatec.bptopics.entity.Usuario;

public interface SegurancaService {

    public Usuario novoUsuario(Usuario usuario);

    public Usuario novoUsuario(String nome, String senha);

    public List<Usuario> todosUsuarios();

    public Usuario buscarPorId(Long id);
}