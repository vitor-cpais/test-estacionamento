package com.teste.estacionamento.Resources;

import com.teste.estacionamento.entities.Carro;
import com.teste.estacionamento.entities.Usuario;
import com.teste.estacionamento.service.CarroService;
import com.teste.estacionamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Resource
@RestController
@RequestMapping(value = "/users")
public class UsuarioResources {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping
    public ResponseEntity<List<Usuario>> findAllUsers(){
        List<Usuario> list = usuarioService.findAllUsers();
        return ResponseEntity.ok().body(list);
    }











}
