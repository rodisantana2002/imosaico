/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.repo;

import com.app.domain.model.Pessoa;
import com.app.domain.orm.core.Irepository;
import com.app.domain.orm.core.repoGeneric;
import org.springframework.stereotype.Repository;

@Repository("repoPessoa")
public class repoPessoa extends repoGeneric<Pessoa> implements Irepository<Pessoa> {

    public repoPessoa() {
        super();
        setClazz(Pessoa.class);
    }
}