/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model.core;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public enum TipoSistema {
    FRONTEND("FrontEnd"),
    BACKEND("BackEnd"),
    API("API"),
    MOBILE("Mobile"),
    DESKTOP("Desktop"),
    IOT("IOT");

    private String descricao;

    TipoSistema(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
