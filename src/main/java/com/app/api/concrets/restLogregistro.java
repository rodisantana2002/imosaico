/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.concrets;

import com.app.domain.model.Logregistro;
import com.app.service.controlls.controll.concrets.ctrlLogregistro;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@RestController
@RequestMapping("v1/logregistros")
public class restLogregistro {

    @Autowired
    private ctrlLogregistro controll;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<Logregistro> listAll() {
        List<Logregistro> all = (List<Logregistro>) this.controll.obterTodos();
        return all;
    }
}
