/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.validator.concrets;

import com.app.domain.model.Sistema;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsSistema;
import com.app.service.business.validator.abstracts.validGeneric;
import java.util.function.Predicate;

/*
 * @author Rodolfo
 */
public class validSistema extends validGeneric<Sistema> {

    public validSistema() {
        super();
    }

    public void validarCamposObrigatorios(Sistema entity) {
        if (entity.getId() != null && entity.getId() == 0) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Identificador" + ").");
        }
        if (entity.getNome() == null || entity.getNome().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Nome" + ").");
        }
        if (entity.getDescricao() == null || entity.getDescricao().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Descrição" + ").");
        }
        if (entity.getLinguagem() == null || entity.getLinguagem().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Linguagem" + ").");
        }
        if (entity.getTipo() == null || entity.getTipo().getDescricao().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Tipo Sistema" + ").");
        }
    }

    public void validarEntidadeCadastrada(Sistema entity, bsSistema ibusiness) {
        Predicate<Sistema> predID = p -> p.getId().equals(entity.getId());
        Predicate<Sistema> predNome = p -> p.getNome().equalsIgnoreCase(entity.getNome());

        if (ibusiness.listarByFilter(entity, predID).size() > 0) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE);
        }

        if (ibusiness.listarByFilter(entity, predNome).size() > 0) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE + " (Nome já foi vinculado a outro Sistema).");
        }
    }

    public void validarEntidadeNaoCadastrada(Sistema entity, bsSistema ibusiness) {
        Predicate<Sistema> predID = p -> p.getId().equals(entity.getId());
        Predicate<Sistema> predNome = (p -> p.getNome().equalsIgnoreCase(entity.getNome()) && p.getId() != entity.getId());

        if (ibusiness.listarByFilter(entity, predID).isEmpty()) {
            getMessages().add(excMessages.STR_REG_NAO_EXISTE);
        }

        if (ibusiness.listarByFilter(entity, predNome).size() > 0) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE + " (Nome já foi vinculado a outro Sistema).");
        }
    }

}
