package com.apirest.service;

import com.apirest.model.dto.EnderecoDto;
import com.apirest.model.entity.UsuarioEntity;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    UsuarioEntity criarUsuario(UsuarioEntity usuario);
    Optional<UsuarioEntity> buscarUsuarioPorEmail(String email);
    Optional<UsuarioEntity> buscarUsuarioPorCpf(String cpf);
    List<String> validarCpfEmail(String email, String cpf);
    boolean adicionarEndereco(EnderecoDto usuario);
    UsuarioEntity buscarUsuarioPorId(Integer idUsuario);
}
