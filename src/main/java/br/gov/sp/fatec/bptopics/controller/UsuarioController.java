package br.gov.sp.fatec.bptopics.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.sp.fatec.bptopics.dto.UserAlmostEmpty;
import br.gov.sp.fatec.bptopics.entity.Usuario;
import br.gov.sp.fatec.bptopics.service.SegurancaService;

@CrossOrigin
@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
    
    @Autowired
    private SegurancaService segurancaService;

    @GetMapping
    public List<Usuario> buscarTodos() {
        return segurancaService.todosUsuarios();
    }

    @GetMapping(value = "/{id}")
    public Usuario buscarPorId(@PathVariable(name = "id") Long id) {
        return segurancaService.buscarPorId(id);
    }

    @GetMapping(value = "/nome/{nome}")
    public List<Usuario> buscarPorNome(@PathVariable("nome") String nome) {
        return segurancaService.burcarPorNome(nome);
    }

    @PostMapping
    public Usuario novoUsuarioFull(@RequestBody Usuario usuario) {
        return segurancaService.novoUsuario(usuario.getNome(), usuario.getSenha());
    }

    @PostMapping(value = "/novo")
    public Usuario novoUsuarioAlmostEmpty(@RequestBody UserAlmostEmpty usuario) {
        return segurancaService.novoUsuario(usuario.getNome(), usuario.getSenha());
    }
}
