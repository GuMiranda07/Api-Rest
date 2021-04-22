package com.apirest.service;

import com.apirest.model.dto.EnderecoDto;
import com.apirest.mapper.EnderecoMapper;
import com.apirest.model.entity.EnderecoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private ViacepService viacepService;

    @Override
    public EnderecoEntity obterEndereco(EnderecoDto enderecoDto) {
        var enderecoViacep = this.viacepService.getEnderecoViacep(enderecoDto.getCep());
        var enderecoEntity = EnderecoMapper.convertFrom(enderecoViacep);
        enderecoEntity.setNumero(enderecoDto.getNumero());
        enderecoEntity.setComplemento(enderecoDto.getComplemento());
        return enderecoEntity;
    }
}
