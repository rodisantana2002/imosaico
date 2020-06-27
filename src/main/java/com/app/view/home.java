/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.view;

import com.app.domain.model.pessoa;
import com.app.domain.orm.repo.PessoaRepo;
import com.app.helpers.mensagens.clsPSR;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author osboxes
 */
public class home {

    @Autowired
    private PessoaRepo pessoaRepo;

    public void t() {
        pessoa pessoa = new pessoa();
        List<pessoa> pessoas = pessoaRepo.findAll();
        clsPSR.prt(String.valueOf(pessoas.size()));

    }
}
