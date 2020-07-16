/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Logregistro;
import com.app.helpers.excecoes.excMessages;
import com.app.helpers.mensagens.clsPSR;
import com.app.service.business.bs.concrets.bsLogregistro;
import com.app.service.business.validator.concrets.validLogregistro;
import com.app.service.controlls.core.Icontroll;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
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

    private Gson gson;

    public ctrlLogregistro() {
        gson = new Gson();
    }

    @Override
    public List<String> salvar(Logregistro entity) {
        List<String> msgs = new ArrayList<String>();
        msgs = validar(entity);

        if (msgs.isEmpty()) {
            if (entity.getId() == null) {
                entity = ibusiness.create(entity);
            } else {
                entity = ibusiness.update(entity);
            }
            msgs.add(excMessages.STR_REG_LOG_SUCESSO);
            msgs.add(gson.toJson(ibusiness.consultar(entity).get()));
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
            msgs.add(excMessages.STR_DEL_LOG_SUCESSO);
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
    public List<Logregistro> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion, Map<String, String> allFilters) {
        // predicate generic
        Predicate<Logregistro> prePadrao = p -> (1 == 1);

        if (allFilters != null) {
            if (!allFilters.isEmpty()) {
                if (allFilters.containsKey("tipo")) {
                    Predicate<Logregistro> preTipo = p -> p.getTipo().getDescricao().toLowerCase().equals(allFilters.get("tipo").toLowerCase());
                    clsPSR.prt("filtrando pelo tipo");
                    prePadrao = prePadrao.and(preTipo);
                }
                if (allFilters.containsKey("descricao")) {
                    Predicate<Logregistro> preDescricao = p -> p.getDescricao().toLowerCase().contains(allFilters.get("descricao").toLowerCase());
                    clsPSR.prt("filtrando pela descricao");
                    prePadrao = prePadrao.and(preDescricao);
                }
                if (allFilters.containsKey("log")) {
                    Predicate<Logregistro> preLog = p -> p.getLog().toLowerCase().contains(allFilters.get("log").toLowerCase());
                    clsPSR.prt("filtrando pelo log");
                    prePadrao = prePadrao.and(preLog);
                }
                if (allFilters.containsKey("origem")) {
                    Predicate<Logregistro> preOrigem = p -> p.getOrigem().toLowerCase().equals(allFilters.get("origem").toLowerCase());
                    clsPSR.prt("filtrando pela origem");
                    prePadrao = prePadrao.and(preOrigem);
                }
                if (allFilters.containsKey("dtregistro")) {
                    Predicate<Logregistro> preData = p -> p.getDtregistro().contains(allFilters.get("dtregistro").toLowerCase());
                    clsPSR.prt("filtrando pela data");
                    prePadrao = prePadrao.and(preData);
                }
                if (allFilters.containsKey("qtde")) {
                    Predicate<Logregistro> preQtde = p -> p.getQtde().toString().equals(allFilters.get("qtde"));
                    clsPSR.prt("filtrando pela qtde");
                    prePadrao = prePadrao.and(preQtde);
                }
                return ibusiness.listarAll(pageNo, pageSize, sortBy, diretion).stream().filter(prePadrao).collect(Collectors.toList());
            }
        }

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

    @Override
    public String toString() {
        return "Logregistro";
    }
}
