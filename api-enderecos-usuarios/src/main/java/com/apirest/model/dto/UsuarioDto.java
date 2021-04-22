package com.apirest.model.dto;

import javax.validation.constraints.NotNull;
import java.util.List;

public class UsuarioDto {
    private Integer id;
    @NotNull(message = "O nome do usuario nao pode ser nulo")
    private String nome;
    @NotNull(message = "O email do usuario nao pode ser nulo")
    private String email;
    @NotNull(message = "O cpf nao pode ser nulo")
    private String cpf;
    @NotNull(message = "A data de nascimento nao pode ser nula")
    private String dataNascimento;
    private List<EnderecoResponseDto> enderecos;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCpf() {
        return cpf;
    }
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    public String getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public List<EnderecoResponseDto> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(List<EnderecoResponseDto> enderecos) {
        this.enderecos = enderecos;
    }
}
