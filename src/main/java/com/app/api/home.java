/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api;

import com.app.domain.model.Pessoa;
import com.app.helpers.mensagens.clsPSR;
import com.app.service.business.bs.concrets.bsPessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author osboxes
 */
@Controller
public class home {

    @Autowired
    bsPessoa pessoas;

    @RequestMapping("/home")
    String index() {

        Pessoa p = new Pessoa();
        p.setId(18l);
        clsPSR.prt(pessoas.consultar(p).toString());
        return "index";
    }

}
