package com.apirest.mapper;

import com.apirest.model.dto.UsuarioDto;
import com.apirest.exception.DataNascimentoException;
import com.apirest.model.entity.UsuarioEntity;

import java.util.stream.Collectors;

public class UsuarioMapper {

    public static UsuarioEntity convertFrom(UsuarioDto usuarioDto) throws DataNascimentoException {
        var usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(usuarioDto.getNome());
        usuarioEntity.setCpf(usuarioDto.getCpf());
        usuarioEntity.setEmail(usuarioDto.getEmail());
        usuarioEntity.setDataNascimento(DataNascimentoMapper.convertFrom(usuarioDto.getDataNascimento()));
        return usuarioEntity;
    }

    public static UsuarioDto convertFrom(UsuarioEntity usuarioEntity) {
        var usuarioDto = new UsuarioDto();
        usuarioDto.setId(usuarioEntity.getId());
        usuarioDto.setNome(usuarioEntity.getNome());
        usuarioDto.setCpf(usuarioEntity.getCpf());
        usuarioDto.setEmail(usuarioEntity.getEmail());
        usuarioDto.setDataNascimento(DataNascimentoMapper.convertFrom(usuarioEntity.getDataNascimento()));
        usuarioDto.setEnderecos(usuarioEntity.getEnderecos()
                .stream()
                .map(EnderecoMapper::convertFrom)
                .collect(Collectors.toList()));
        return usuarioDto;
    }
}
