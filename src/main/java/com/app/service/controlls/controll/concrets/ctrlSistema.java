/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Sistema;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsSistema;
import com.app.service.business.core.Ivalidator;
import com.app.service.business.factory.validatorFactory;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rodolfo //
 */
@Service
@Transactional
public class ctrlSistema implements Icontroll<Sistema> {

    @Autowired
    private bsSistema ibusiness;
    private Ivalidator<Sistema> ivalidator;

    public ctrlSistema() {
        ivalidator = new validatorFactory<Sistema>(new Sistema()).getValidator();
    }

    public List<String> salvar(Sistema entity) {
        List<String> msgs = new ArrayList<String>();
        msgs = validar(entity);

        if (msgs.isEmpty()) {
            if (entity.getId() == null) {
                ibusiness.create(entity);
            } else {
                ibusiness.update(entity);
            }
            msgs.add(excMessages.STR_REG_SISTEMA_SUCESSO);
            return msgs;
        }
        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
        return msgs;
    }

    public List<String> deletar(Sistema entity) {
        List<String> msgs = validarDelete(entity);

        if (msgs.isEmpty()) {
            deletar(entity);
            msgs.add(excMessages.STR_DEL_SISTEMA_SUCESSO);
            return msgs;
        }
        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
        return msgs;
    }

    @Override
    public Sistema obter(Long id) {
        Sistema p = new Sistema();
        p.setId(id);
        return (Sistema) ibusiness.consultar(p);
    }

    @Override
    public List<Sistema> obterTodos() {
        ArrayList<Sistema> listaSistema = (ArrayList<Sistema>) ibusiness.listarAll();
        return listaSistema;
    }

    @Override
    public List<Sistema> obterByFilter(Sistema entity, Predicate<Sistema> predicate) {
        ArrayList<Sistema> listaSistema = (ArrayList<Sistema>) ibusiness.listarByFilter(entity, predicate);
        return listaSistema;
    }

    private List<String> validarDelete(Sistema entity) {
        List<String> regras = new ArrayList<String>();

        if (entity.getId() != null) {
            regras.add("validarEntidadeNaoCadastrada");
        }
        return ivalidator.validarRegras(entity, regras, ibusiness);
    }

    private List<String> validar(Sistema entity) {
        List<String> regras = new ArrayList<String>();
        regras.add("validarCamposObrigatorios");

        if (entity.getId() == null) {
            regras.add("validarEntidadeCadastrada");
        } else {
            regras.add("validarEntidadeNaoCadastrada");
        }
        return ivalidator.validarRegras(entity, regras, ibusiness);
    }

    @Override
    public String toString() {
        return "Sistema";
    }
}
