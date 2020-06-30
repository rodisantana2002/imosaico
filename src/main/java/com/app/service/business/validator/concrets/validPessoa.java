/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.validator.concrets;

import com.app.domain.model.Pessoa;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsPessoa;
import com.app.service.business.validator.abstracts.validGeneric;
import java.util.function.Predicate;

/*
 * @author Rodolfo
 */
public class validPessoa extends validGeneric<Pessoa> {

    public validPessoa() {
        super();
    }

    public void validarCamposObrigatorios(Pessoa entity, bsPessoa ibusiness) {
        if (entity.getId() != null && entity.getId() == 0) {
            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Identificador" + ").");
        }
        if (entity.getNomecompleto() == null || entity.getNomecompleto().trim().isEmpty()) {
            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Nome completo" + ").");
        }
        if (entity.getEmail() == null || entity.getEmail().trim().isEmpty()) {
            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Email" + ").");
        }
    }

    public void validarPessoaCadastrada(Pessoa entity, bsPessoa ibusiness) {
        Predicate<Pessoa> predID = p -> p.getId().equals(entity.getId());
        Predicate<Pessoa> predEMail = p -> p.getEmail().equalsIgnoreCase(entity.getEmail());

        if (ibusiness.listarByFilter(entity, predID).size() > 0) {
            getLstMsg().add(excMessages.STR_REG_JA_EXISTE);
        }

        if (ibusiness.listarByFilter(entity, predEMail).size() > 0) {
            getLstMsg().add(excMessages.STR_REG_JA_EXISTE + " (Email já foi vinculado a outra Pessoa).");
        }
    }

    public void validarPessoaNaoCadastrada(Pessoa entity, bsPessoa ibusiness) {
        Predicate<Pessoa> predID = p -> p.getId().equals(entity.getId());
        if (ibusiness.listarByFilter(entity, predID).isEmpty()) {
            getLstMsg().add(excMessages.STR_REG_NAO_EXISTE);
        }
    }
}
