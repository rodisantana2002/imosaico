/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helpers.excecoes;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
@ResponseBody
public class excAcessDeniedException extends RuntimeException {

    public excAcessDeniedException(String msg) {
        super(msg);
    }
}
