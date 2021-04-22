package com.apirest.controller;

import com.apirest.model.dto.UsuarioDto;
import com.apirest.exception.DataNascimentoException;
import com.apirest.mapper.DataNascimentoMapper;
import com.apirest.mapper.UsuarioMapper;
import com.apirest.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity criarNovoUsuario(@Valid @RequestBody UsuarioDto usuario, BindingResult result) throws DataNascimentoException {
        var erros = this.validateDto(usuario, result);
        if(!erros.isEmpty()) return ResponseEntity.badRequest().body(erros);
        this.usuarioService.criarUsuario(UsuarioMapper.convertFrom(usuario));
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity buscarEnderecosPorIdUsuario(@PathVariable("idUsuario") Integer idUsuario) {
        var usuario = this.usuarioService.buscarUsuarioPorId(idUsuario);
        if(usuario != null) return ResponseEntity.ok(UsuarioMapper.convertFrom(usuario));
        return ResponseEntity.badRequest().body("Usuario nao encontrado");
    }

    private List<String> validateDto(UsuarioDto usuarioDto, BindingResult result) {
        var erros = this.usuarioService.validarCpfEmail(usuarioDto.getEmail(), usuarioDto.getCpf());
        if(DataNascimentoMapper.verificarSeDataNaoEhValida(usuarioDto.getDataNascimento())) erros.add("Verifique se a data de nascimento esta no padrao dd-MM-yyyy");
        result.getAllErrors()
                .stream()
                .forEach(error -> erros.add(error.getDefaultMessage()));

        return erros;
    }

}
