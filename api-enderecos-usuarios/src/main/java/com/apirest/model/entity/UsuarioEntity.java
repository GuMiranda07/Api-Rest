package com.apirest.model.entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name="usuarios")
public class UsuarioEntity {
    @Id
    @SequenceGenerator(name="usuario_id_generator",
            sequenceName="usuario_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_id_generator")
    private int id;

    @Column(name="nome", nullable=false)
    private String nome;

    @Column(name="email", unique=true, nullable=false)
    private String email;

    @Column(name="cpf", unique=true, nullable=false)
    private String cpf;

    @Column(name="data_nascimento", nullable=false)
    private LocalDate dataNascimento;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<EnderecoEntity> enderecos;

    public int getId() {
        return id;
    }
    public void setId(int id) {
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
    public LocalDate getDataNascimento() {
        return dataNascimento;
    }
    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    public List<EnderecoEntity> getEnderecos() {
        return enderecos;
    }
    public void setEnderecos(List<EnderecoEntity> enderecos) {
        this.enderecos = enderecos;
    }
}