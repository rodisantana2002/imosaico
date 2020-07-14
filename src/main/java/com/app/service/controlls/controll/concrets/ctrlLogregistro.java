/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Logregistro;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsLogregistro;
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

    public ctrlLogregistro() {
    }

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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Logregistro> obter(Long id) {
        return null;
    }

    @Override
    public List<Logregistro> obterTodos() {
        return ibusiness.listarAll();
    }

    @Override
    public List<Logregistro> obterByFilter(Logregistro entity, Predicate<Logregistro> predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private List<String> validar(Logregistro entity) {
//        List<String> regras = new ArrayList<String>();
//        regras.add("validarCamposObrigatorios");
//
//        if (entity.getId() == null) {
//            regras.add("validarPessoaCadastrada");
//        } else {
//            regras.add("validarPessoaNaoCadastrada");
//        }
//        return ivalidator.validarRegras(entity, regras, ibusiness);
        return new ArrayList<String>();
    }

    @Override
    public List<Logregistro> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
