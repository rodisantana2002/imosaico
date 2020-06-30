/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model;

import com.app.domain.model.core.core;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Entity
public class Usuario extends core {

    private String senha;
    private String token;
    private Boolean superuser;

    @OneToOne
    @JoinColumn(name = "idpessoa")
    private Pessoa pessoa;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public Boolean isSuperuser() {
        return superuser;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
}
