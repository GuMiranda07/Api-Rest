package com.apirest.controller;

import com.apirest.model.dto.EnderecoDto;
import com.apirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity criarEndereco(@RequestBody EnderecoDto enderecoDto) {
        var adicionado = this.usuarioService.adicionarEndereco(enderecoDto);
        if(adicionado) return ResponseEntity.status(HttpStatus.CREATED).build();
        return ResponseEntity.badRequest().build();
    }
}
