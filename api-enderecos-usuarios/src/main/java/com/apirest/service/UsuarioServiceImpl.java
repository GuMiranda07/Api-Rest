package com.apirest.service;

import com.apirest.model.dto.EnderecoDto;
import com.apirest.model.entity.UsuarioEntity;
import com.apirest.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Override
    public UsuarioEntity criarUsuario(UsuarioEntity usuario) {
        return this.usuarioRepository.save(usuario);
    }

    @Override
    public Optional<UsuarioEntity> buscarUsuarioPorEmail(String email) {
        return this.usuarioRepository.findByEmail(email);
    }

    @Override
    public Optional<UsuarioEntity> buscarUsuarioPorCpf(String cpf) {
        return this.usuarioRepository.findByCpf(cpf);
    }

    @Override
    public List<String> validarCpfEmail(String email, String cpf) {
       var emailExiste = this.usuarioRepository.findByEmail(email).isPresent();
       var cpfExiste = this.usuarioRepository.findByCpf(cpf).isPresent();
       return this.montarMensagemDeErro(emailExiste, cpfExiste);
    }

    @Override
    public boolean adicionarEndereco(EnderecoDto enderecoDto) {
        var usuario = this.usuarioRepository.findById(enderecoDto.getIdUsuario());
        var endereco = this.enderecoService.obterEndereco(enderecoDto);
        if(usuario.isEmpty() || endereco.getCep() == null) return false;
        usuario.get().getEnderecos().add(endereco);
        this.usuarioRepository.save(usuario.get());
        return true;
    }

    @Override
    public UsuarioEntity buscarUsuarioPorId(Integer idUsuario) {
       return this.usuarioRepository.findById(idUsuario).orElse(null);
    }

    private List<String> montarMensagemDeErro(Boolean emailExiste, Boolean cpfExiste) {
        var erros = new ArrayList();
        if(emailExiste) erros.add("Email ja esta em uso!");
        if(cpfExiste) erros.add("CPF ja em esta uso!");
        return erros;
    }
}
