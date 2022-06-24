package com.teste.estacionamento.service;


import com.teste.estacionamento.entities.Usuario;
import com.teste.estacionamento.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    public List<Usuario> findAllUsers() {
        return usuarioRepository.findAll();
    }



}
