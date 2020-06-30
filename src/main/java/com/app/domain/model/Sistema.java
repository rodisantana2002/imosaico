/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model;

import com.app.domain.model.core.core;
import com.app.domain.model.core.tiposistema;
import javax.persistence.Entity;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Entity
public class Sistema extends core {

    private String nome;
    private String descricao;
    private tiposistema tipo;
    private String linguagem;

    public Sistema() {
    }

    public Sistema(String nome, String descricao, String tipo, String linguagem) {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public tiposistema getTipo() {
        return tipo;
    }

    public void setTipo(tiposistema tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLinguagem() {
        return linguagem;
    }

    public void setLinguagem(String linguagem) {
        this.linguagem = linguagem;
    }
}
