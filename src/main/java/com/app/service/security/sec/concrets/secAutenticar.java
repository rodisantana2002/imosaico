/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.security.sec.concrets;

import com.app.domain.model.Usuario;
import com.app.service.controlls.controll.concrets.ctrlUsuario;
import com.app.service.security.core.Isecurity;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * // * // * @author Rodolfo //
 */
@Service
@Transactional
public class secAutenticar implements Isecurity<Usuario> {

    private ctrlUsuario ctrlusuario;

    public secAutenticar() {
        ctrlusuario = new ctrlUsuario();
    }

    @Override
    public List<String> autenticarUsuario(Usuario entity) {
        return ctrlusuario.autenticarUsuario(entity);
    }

    @Override
    public List<String> autenticarTokenUsuario(Usuario entity) {
        return ctrlusuario.autenticarToken(entity);
    }

    @Override
    public void efetuarLogout(Usuario entity) {
        ctrlusuario.efetuarLogout(entity);
    }

    @Override
    public Usuario getUser(Usuario entity) {
        //atualiza token na pessoa e retorna
        return ctrlusuario.atualizarToken(entity);
    }

    public String enviarSenha(String email) {
        return ctrlusuario.enviarSenha(email);
    }
}
