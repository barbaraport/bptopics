package br.gov.sp.fatec.bptopics.service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.gov.sp.fatec.bptopics.entity.Autorizacao;
import br.gov.sp.fatec.bptopics.entity.Usuario;
import br.gov.sp.fatec.bptopics.repository.AutorizacaoRepository;
import br.gov.sp.fatec.bptopics.repository.UsuarioRepository;

@Service
public class SegurancaServiceImpl implements SegurancaService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private AutorizacaoRepository autorizacaoRepository;

    @Override
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public Usuario novoUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario novoUsuario(String nome, String senha) {

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);

        return novoUsuario(usuario);
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public List<Usuario> todosUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    @PreAuthorize("isAuthenticated()")
    public Usuario buscarPorId(Long id) {
        
        Optional<Usuario> usuarioOptional = usuarioRepository.findById(id);
        
        if (usuarioOptional.isPresent()) {
            return usuarioOptional.get();
        }

        throw new RuntimeException("Usuario nao encontrado");
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByNome(username);
        if (usuario == null) {
          throw new UsernameNotFoundException("Usuário " + username + " não encontrado!");
        }
        return User.builder().username(username).password(usuario.getSenha())
            .authorities(usuario.getAutorizacoes().stream()
                .map(Autorizacao::getNome).collect(Collectors.toList())
                .toArray(new String[usuario.getAutorizacoes().size()]))
            .build();
    }

    @Override
    @Transactional
    public Usuario novoUsuario(String nome, String senha, String autorizacao) {
        Autorizacao aut = autorizacaoRepository.findByNome(nome);

        if (aut == null) {
            aut = new Autorizacao();
            aut.setNome(nome);
            autorizacaoRepository.save(aut);
        }

        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setSenha(senha);
        usuario.setAutorizacoes(new HashSet<Autorizacao>());
        usuario.getAutorizacoes().add(aut);

        return novoUsuario(usuario);
    }
    
}
