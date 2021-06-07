package com.george.orangetalent.services;

import com.george.orangetalent.dtos.UsuarioDto;
import com.george.orangetalent.entities.Usuario;
import com.george.orangetalent.repositories.UsuarioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServices {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> listar() {
        return usuarioRepository.findAll();
    }

    public Usuario salvar(UsuarioDto usuarioDto) {

        Usuario usuario = new Usuario();

        usuario.setCpf(usuarioDto.getCpf());
        usuario.setEmail(usuarioDto.getEmail());
        usuario.setNome(usuarioDto.getNome());
        usuario.setNascimento(usuarioDto.getNascimento());

        return usuarioRepository.save(usuario);
    }

    public Usuario buscar(Long id) {
        Usuario usuario = usuarioRepository.findOne(id);

        if (usuario == null) {
        }
        return usuario;
    }
}