/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.bs.concrets;

import com.app.domain.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.app.domain.orm.core.Irepository;
import com.app.service.business.bs.abstracts.bsGeneric;

/**
 *
 * @author Rodolfo
 */
@Service
@Transactional
public class bsPessoa extends bsGeneric<Pessoa> {

    @Autowired
    private Irepository Dao;

    public bsPessoa() {
        super();
    }

}
