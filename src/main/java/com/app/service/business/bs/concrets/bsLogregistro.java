/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.bs.concrets;

import com.app.domain.model.Logregistro;
import com.app.domain.orm.core.Irepository;
import com.app.service.business.bs.abstracts.bsGeneric;
import com.app.service.business.core.Ibusiness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Service
@Transactional
public class bsLogregistro extends bsGeneric<Logregistro> implements Ibusiness<Logregistro> {

    @Autowired
    private Irepository<Logregistro> Dao;

    public bsLogregistro() {
        super();
    }

}
