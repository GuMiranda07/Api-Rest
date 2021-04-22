package com.apirest.service;

import com.apirest.model.viacep.EnderecoViacepDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "viacep", url = "https://viacep.com.br")
public interface ViacepService {
    @RequestMapping(method = RequestMethod.GET, value = "/ws/{cep}/json")
    EnderecoViacepDto getEnderecoViacep(@PathVariable("cep") String cep);
}
