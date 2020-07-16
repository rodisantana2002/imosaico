/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.validator.concrets;

import com.app.domain.model.Logregistro;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsLogregistro;
import com.app.service.business.validator.abstracts.validGeneric;
import java.util.function.Predicate;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public class validLogregistro extends validGeneric<Logregistro> {

    public validLogregistro() {
        super();
    }

    public void validarCamposObrigatorios(Logregistro entity, bsLogregistro ibusiness) {
        if (entity.getId() != null && entity.getId() == 0) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Identificador" + ").");
        }
        if (entity.getTipo() == null || entity.getTipo().getDescricao().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Level" + ").");
        }
        if (entity.getDescricao() == null || entity.getDescricao().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Descrição" + ").");
        }
        if (entity.getLog() == null || entity.getLog().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Log do Sistema" + ").");
        }
        if (entity.getSistema() == null || entity.getSistema().getId() == null || entity.getSistema().getId() == 0) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Id - Sistema de Origem" + ").");
        }
        if (entity.getSistema() == null || entity.getSistema().getNome() == null || entity.getSistema().getNome().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Nome - Sistema de Origem" + ").");
        }
        if (entity.getQtde() == null) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Qtde" + ").");
        }
        if (entity.getQtde() < 0) {
            getMessages().add(excMessages.STR_DADOS_VALIDOS + " - (" + "Qtde" + ").");
        }
    }

    public void validarLogregistroCadastrada(Logregistro entity, bsLogregistro ibusiness) {
        Predicate<Logregistro> predID = p -> p.getId().equals(entity.getId());
        Predicate<Logregistro> predSistema = p -> p.getSistema().getId().equals(entity.getSistema().getId());

        if (!ibusiness.listarByFilter(entity, predID).isEmpty()) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE);
        }

        // verifica se o sistema informado existe
        if (ibusiness.listarByFilter(entity, predSistema).isEmpty()) {
            getMessages().add(excMessages.STR_SISTEMA_NAO_EXISTE);
        }

    }

    public void validarLogregistroNaoCadastrada(Logregistro entity, bsLogregistro ibusiness) {
        Predicate<Logregistro> predID = p -> p.getId().equals(entity.getId());
        if (ibusiness.listarByFilter(entity, predID).isEmpty()) {
            getMessages().add(excMessages.STR_REG_NAO_EXISTE);
        }
    }
}
