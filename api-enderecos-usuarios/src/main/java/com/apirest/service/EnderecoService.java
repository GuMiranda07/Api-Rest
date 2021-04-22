package com.apirest.service;

import com.apirest.model.dto.EnderecoDto;
import com.apirest.model.entity.EnderecoEntity;

public interface EnderecoService {
    EnderecoEntity obterEndereco(EnderecoDto enderecoDto);
}
