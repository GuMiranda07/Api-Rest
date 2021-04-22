package com.apirest.mapper;

import com.apirest.model.dto.EnderecoResponseDto;
import com.apirest.model.entity.EnderecoEntity;
import com.apirest.model.viacep.EnderecoViacepDto;

public class EnderecoMapper {
    public static EnderecoEntity convertFrom(EnderecoViacepDto enderecoViacepDto) {
        var endereco = new EnderecoEntity();
        endereco.setBairro(enderecoViacepDto.getBairro());
        endereco.setCep(enderecoViacepDto.getCep());
        endereco.setEstado(enderecoViacepDto.getUf());
        endereco.setLogradouro(enderecoViacepDto.getLogradouro());
        endereco.setCidade(enderecoViacepDto.getLocalidade());
        return endereco;
    }

    public static EnderecoResponseDto convertFrom(EnderecoEntity enderecoEntity) {
        var endereco = new EnderecoResponseDto();
        endereco.setBairro(enderecoEntity.getBairro());
        endereco.setCep(enderecoEntity.getCep());
        endereco.setEstado(enderecoEntity.getEstado());
        endereco.setLogradouro(enderecoEntity.getLogradouro());
        endereco.setCidade(enderecoEntity.getCidade());
        endereco.setNumero(enderecoEntity.getNumero());
        endereco.setComplemento(enderecoEntity.getComplemento());
        endereco.setId(enderecoEntity.getId());
        return endereco;
    }
}
