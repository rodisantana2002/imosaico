/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model.transitorio;

import com.app.domain.model.Pessoa;
import java.io.Serializable;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public class autenticado implements Serializable {

    private String token;
    private Pessoa pessoa;

}
