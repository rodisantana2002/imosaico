/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model;

import com.app.domain.model.core.Core;
import com.app.domain.model.core.TipoSistema;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Entity
@Table(name = "sistema")
public class Sistema extends Core {

    private String nome;
    private String descricao;

    @Enumerated(EnumType.STRING)
    private TipoSistema tipo;
    private String linguagem;

    public Sistema() {
    }

    public Sistema(String nome, String descricao, TipoSistema tipo, String linguagem) {
        this.nome = nome;
        this.descricao = descricao;
        this.tipo = tipo;
        this.linguagem = linguagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoSistema getTipo() {
        return tipo;
    }

    public void setTipo(TipoSistema tipo) {
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

    public String toString() {
        return "Sistema{ id:" + this.getId() + ",\n"
                + "       nome:" + this.nome + ",\n"
                + "  descricao:" + this.descricao + ",\n"
                + "       tipo:" + this.tipo + ",\n"
                + "  linguagem:" + this.linguagem + ",\n"
                + " dtregistro:" + this.getDtregistro() + ",\n"
                + "}";
    }

}
