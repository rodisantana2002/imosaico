/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Logregistro;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsLogregistro;
import com.app.service.business.validator.concrets.validLogregistro;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Service
public class ctrlLogregistro implements Icontroll<Logregistro> {

    @Autowired
    private bsLogregistro ibusiness;

    @Override
    public List<String> salvar(Logregistro entity) {
        List<String> msgs = new ArrayList<String>();
        msgs = validar(entity);

        if (msgs.isEmpty()) {
            if (entity.getId() == null) {
                ibusiness.create(entity);
            } else {
                ibusiness.update(entity);
            }
            msgs.add(excMessages.STR_REG_PESSOA_SUCESSO);
            return msgs;
        }
        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
        return msgs;
    }

    @Override
    public List<String> deletar(Logregistro entity) {
        List<String> msgs = validarDelete(entity);

        if (msgs.isEmpty()) {
            deletar(entity);
            msgs.add(excMessages.STR_DEL_PESSOA_SUCESSO);
            return msgs;
        }
        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
        return msgs;
    }

    @Override
    public Optional<Logregistro> obter(Long id) {
        Logregistro p = new Logregistro();
        p.setId(id);
        return ibusiness.consultar(p);
    }

    @Override
    public List<Logregistro> obterTodos() {
        return ibusiness.listarAll();
    }

    @Override
    public List<Logregistro> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion) {
        return ibusiness.listarAll(pageNo, pageSize, sortBy, diretion);
    }

    @Override
    public List<Logregistro> obterByFilter(Logregistro entity, Predicate<Logregistro> predicate) {
        return ibusiness.listarByFilter(entity, predicate);

    }

    private List<String> validarDelete(Logregistro entity) {
        validLogregistro validaDados = new validLogregistro();

        if (entity.getId() != null) {
            validaDados.validarLogregistroNaoCadastrada(entity, ibusiness);
        }
        return validaDados.getMessages();
    }

    private List<String> validar(Logregistro entity) {
        validLogregistro validaDados = new validLogregistro();
        validaDados.validarCamposObrigatorios(entity, ibusiness);

        if (entity.getId() == null) {
            validaDados.validarLogregistroCadastrada(entity, ibusiness);
        } else {
            validaDados.validarLogregistroNaoCadastrada(entity, ibusiness);
        }
        return validaDados.getMessages();
    }
}
