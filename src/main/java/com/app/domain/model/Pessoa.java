/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model;

import com.app.domain.model.core.core;
import javax.persistence.Entity;

/**
 *
 * @author Rodolfo Santana <RWS Informática>]
 *
 */
@Entity
public class Pessoa extends core {

    private String email;
    private String nomecompleto;
    private String sexo;
    private String fonecelular;
    private String dtnascimento;

    private String logradouro;
    private String numero;
    private String complemento;
    private String cidade;
    private String estado;
    private String cep;

    public Pessoa() {
    }

    public Pessoa(String email, String nomecompleto, String sexo, String fonecelular, String dtnascimento) {
        this.email = email;
        this.nomecompleto = nomecompleto;
        this.sexo = sexo;
        this.fonecelular = fonecelular;
        this.dtnascimento = dtnascimento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomecompleto() {
        return nomecompleto;
    }

    public void setNomecompleto(String nomecompleto) {
        this.nomecompleto = nomecompleto;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getFonecelular() {
        return fonecelular;
    }

    public void setFonecelular(String fonecelular) {
        this.fonecelular = fonecelular;
    }

    public String getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(String dtnascimento) {
        this.dtnascimento = dtnascimento;
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

    public String toString() {
        return "Pessoa {   id:" + getId() + ",\n"
                + "           email:" + getEmail() + ",\n"
                + "           nomecompleto:" + getNomecompleto() + ",\n"
                + "           sexo:" + getSexo() + ",\n"
                + "           fonecelular:" + getFonecelular() + ",\n"
                + "           dtnascimento:" + getDtnascimento() + ",\n"
                + "           logradouro:" + getLogradouro() + ",\n"
                + "           numero:" + getNumero() + ",\n"
                + "           complemento:" + getComplemento() + ",\n"
                + "           cidade:" + getCidade() + ",\n"
                + "           estado:" + getEstado() + ",\n"
                + "           cep:" + getCep() + ",\n"
                + "           dtregistro:" + getDtregistro() + "\n"
                + "}";

    }
}
