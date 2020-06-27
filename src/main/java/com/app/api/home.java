/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api;

import com.app.domain.model.pessoa;
import com.app.domain.orm.repo.PessoaRepo;
import com.app.helpers.mensagens.clsPSR;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author osboxes
 */
@Controller
public class home {

    @RequestMapping("/home")
    String index() {
        t();
        return "index";
    }

    @Autowired
    PessoaRepo pessoaRepo;

    public void t() {
        pessoa pessoa = new pessoa("rodisantana2002@gmail.com", "Rodolfo Santana", "M", "41 999-2749", "05/07/1978");
        pessoaRepo.save(pessoa);
        List<pessoa> pessoas = pessoaRepo.findAll();
        clsPSR.prt(String.valueOf(pessoas.size()));

    }
}
