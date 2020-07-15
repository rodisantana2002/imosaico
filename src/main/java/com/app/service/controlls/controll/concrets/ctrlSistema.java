/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Sistema;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsSistema;
import com.app.service.business.validator.concrets.validSistema;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    public ctrlSistema() {
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

    @Override
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
    public Optional<Sistema> obter(Long id) {
        Sistema p = new Sistema();
        p.setId(id);
        return ibusiness.consultar(p);
    }

    @Override
    public List<Sistema> obterTodos() {
        return ibusiness.listarAll();
    }

    @Override
    public List<Sistema> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion, Map<String, String> allFilters) {
        return ibusiness.listarAll(pageNo, pageSize, sortBy, diretion);
    }

    @Override
    public List<Sistema> obterByFilter(Sistema entity, Predicate<Sistema> predicate) {
        return ibusiness.listarByFilter(entity, predicate);
    }

    private List<String> validarDelete(Sistema entity) {
        validSistema validaDados = new validSistema();

        List<String> regras = new ArrayList<String>();

        if (entity.getId() != null) {
            validaDados.validarEntidadeNaoCadastrada(entity, ibusiness);
        }
        return validaDados.getMessages();
    }

    private List<String> validar(Sistema entity) {
        validSistema validaDados = new validSistema();

        validaDados.validarCamposObrigatorios(entity);
        if (entity.getId() == null) {
            validaDados.validarEntidadeCadastrada(entity, ibusiness);
        } else {
            validaDados.validarEntidadeNaoCadastrada(entity, ibusiness);
        }

        return validaDados.getMessages();
    }

    @Override
    public String toString() {
        return "Sistema";
    }
}
