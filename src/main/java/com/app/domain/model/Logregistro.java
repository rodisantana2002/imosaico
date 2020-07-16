/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model;

import com.app.domain.model.core.Core;
import com.app.domain.model.core.Level;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Entity
@Table(name = "logregistro")
public class Logregistro extends Core {

    @Enumerated(EnumType.STRING)
    private Level tipo;
    private String descricao;
    private Integer qtde;
    private String log;

    @OneToOne
    @JoinColumn(name = "idsistema")
    private Sistema sistema;

    public Logregistro() {
        this.sistema = new Sistema();
    }

    public Logregistro(Level tipo, String descricao, String log, Sistema sistema, Integer qtde) {
        this.tipo = tipo;
        this.descricao = descricao;
        this.log = log;
        this.sistema = sistema;
        this.qtde = qtde;
    }

    public Level getTipo() {
        return tipo;
    }

    public void setTipo(Level tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public void setSistema(Sistema sistema) {
        this.sistema = sistema;
    }

    public Integer getQtde() {
        return qtde;
    }

    public void setQtde(Integer qtde) {
        this.qtde = qtde;
    }

    public String toString() {
        return "LogRegsitro { id:" + this.getId() + ",\n"
                + "            tipo : " + this.getTipo() + ",\n"
                + "       descricao : " + this.getDescricao() + ",\n"
                + "             log :" + this.getLog() + ",\n"
                + "           origem:" + this.getSistema().getNome() + ",\n"
                + "            qtde:" + this.getQtde() + ",\n"
                + "      dtregistro:" + this.getDtregistro() + "\n"
                + "}";
    }
}
