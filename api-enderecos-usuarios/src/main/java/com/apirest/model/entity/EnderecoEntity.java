package com.apirest.model.entity;

import javax.persistence.*;

@Entity
@Table(name="enderecos")
public class EnderecoEntity {
    @Id
    @SequenceGenerator(name="endereco_id_generator",
            sequenceName="endereco_id_seq",
            allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "endereco_id_generator")
    private int id;

    @Column(name="logradouro", nullable = false)
    private String logradouro;

    @Column(name="numero", nullable = false)
    private String numero;

    @Column(name="complemento")
    private String complemento;

    @Column(name="bairro", nullable = false)
    private String bairro;

    @Column(name="cidade", nullable = false)
    private String cidade;

    @Column(name="estado", nullable = false)
    private String estado;

    @Column(name="cep", nullable = false)
    private String cep;

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getLogradouro() {
        return logradouro;
    }
    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public String getComplemento() {
        return complemento;
    }
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }
    public String getBairro() {
        return bairro;
    }
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String getCidade() {
        return cidade;
    }
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getCep() {
        return cep;
    }
    public void setCep(String cep) {
        this.cep = cep;
    }
}
