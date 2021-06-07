package com.george.orangetalent.controller;

import com.george.orangetalent.dtos.UsuarioDto;
import com.george.orangetalent.entities.Usuario;
import com.george.orangetalent.responses.Response;
import com.george.orangetalent.services.UsuarioServices;
import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/orangetalent/usuarios")
public class GerenciadorDeUsuarios {

    @Autowired
    private UsuarioServices usuarioServices;

    @PostMapping(path = "/new")
    public ResponseEntity<Response<Usuario>> cadastrar(
            @Valid @RequestBody UsuarioDto usuarioDto, BindingResult result) {
        
        Response<Usuario> response = new Response<>();

        if (result.hasErrors()) {
            result.getAllErrors().forEach(error -> response.getErrors()
                    .add(error.getDefaultMessage()));
            return ResponseEntity.badRequest().body(response);
        }

        Usuario usuarioSalvo = this.usuarioServices.salvar(usuarioDto);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(usuarioDto.getId())
                .toUri();
        response.setData(usuarioSalvo);
        return ResponseEntity.created(location).body(response);
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuarios = usuarioServices.listar();
        return ResponseEntity.status(HttpStatus.OK).body(usuarios);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Response<Usuario>>buscar(@PathVariable("id") Long id){

        Usuario usuario = usuarioServices.buscar(id);
        Response<Usuario> response = new Response<>();
        response.setData(usuario);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
