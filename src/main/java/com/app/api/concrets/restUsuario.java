/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.concrets;

import com.app.api.abstracts.restController;
import com.app.domain.model.Pessoa;
import com.app.domain.model.Usuario;
import com.app.domain.model.transitorio.Registro;
import com.app.helpers.excecoes.excViolacaoRegrasNegocio;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@RestController
@RequestMapping("v1/usuarios")
public class restUsuario extends restController<Usuario> {

    public restUsuario() {
        super();
    }

    @RequestMapping(path = "/registro", method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> registro(@RequestBody Registro entity) {
        BCryptPasswordEncoder cripto = new BCryptPasswordEncoder();

        // carregar objetos
        Pessoa pessoa = new Pessoa();
        pessoa.setEmail(entity.getEmail());
        pessoa.setNomecompleto(entity.getNomecompleto());
        pessoa.setSexo(entity.getSexo());
        pessoa.setDtnascimento(entity.getDtnascimento());
        pessoa.setFonecelular(entity.getFonecelular());

        Usuario usuario = new Usuario();
        usuario.setPessoa(pessoa);
        usuario.setSenha(cripto.encode(entity.getSenha()));

        List<String> msg = this.controll.salvar(usuario);
        Map<String, Object> m = new HashMap<>();

        if (msg.contains("Status 400")) {
            List<String> msgs = new ArrayList<>();

            for (String var : msg) {
                msgs.add(var);
            }
            throw new excViolacaoRegrasNegocio(msgs.toString());
        }
        m.put("msg", msg);
        return m;
    }

}
