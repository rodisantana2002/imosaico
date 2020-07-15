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
public enum Level {
    INFO("Info"),
    WARNING("Warning"),
    ERROR("Error");

    private String descricao;

    Level(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

}
