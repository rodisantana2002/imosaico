/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.repo;

import com.app.domain.model.Sistema;
import com.app.domain.orm.core.Irepository;
import com.app.domain.orm.core.repoGeneric;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Repository("repoSistema")
public class repoSistema extends repoGeneric<Sistema> implements Irepository<Sistema> {

    public repoSistema() {
        super();
        setClazz(Sistema.class);
    }

}
