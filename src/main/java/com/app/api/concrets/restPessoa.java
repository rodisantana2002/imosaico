/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.concrets;

import com.app.api.abstracts.restController;
import com.app.domain.model.Pessoa;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author osboxes
 */
@RestController
@RequestMapping("v1/perfis")
public class restPessoa extends restController<Pessoa> {
}
