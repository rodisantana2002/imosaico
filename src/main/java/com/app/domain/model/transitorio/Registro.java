/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model.transitorio;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public class Registro {

    private String email;
    private String nomecompleto;
    private String sexo;
    private String fonecelular;
    private String dtnascimento;
    private String senha;

    public Registro() {
    }

    public Registro(String email, String nomecompleto, String sexo, String fonecelular, String dtnascimento, String Senha) {
        this.email = email;
        this.nomecompleto = nomecompleto;
        this.sexo = sexo;
        this.fonecelular = fonecelular;
        this.dtnascimento = dtnascimento;
        this.senha = senha;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
