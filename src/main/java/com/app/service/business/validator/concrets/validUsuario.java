/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.validator.concrets;

import com.app.domain.model.Usuario;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsUsuario;
import com.app.service.business.validator.abstracts.validGeneric;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author Rodolfo
 */
public class validUsuario extends validGeneric<Usuario> {

    public validUsuario() {
        super();
    }

    public void validarCamposObrigatorios(Usuario entity) {
        if (entity.getId() != null && entity.getId() == 0) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Identificador" + ").");
        }
        if (entity.getPessoa().getNomecompleto() == null || entity.getPessoa().getNomecompleto().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Nome Completo" + ").");
        }
        if (entity.getPessoa().getEmail() == null || entity.getPessoa().getEmail().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Email" + ").");
        }
        if (entity.getPessoa().getFonecelular() == null || entity.getPessoa().getFonecelular().trim().isEmpty()) {
            getMessages().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Telefone Celular" + ").");
        }
    }

    public void validarRegistroCadastrado(Usuario entity, bsUsuario ibusiness) {
        Predicate<Usuario> predID = p -> p.getId().equals(entity.getId());
        Predicate<Usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(entity.getPessoa().getEmail());
        Predicate<Usuario> predFoneCelular = p -> p.getPessoa().getFonecelular().equals(entity.getPessoa().getFonecelular());

        if (ibusiness.listarByFilter(entity, predID).size() > 0) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE);
        }

        List<Usuario> lstUsuarios = ibusiness.listarByFilter(entity, predEMail);
        if (!lstUsuarios.isEmpty() && lstUsuarios.get(0).getId() != null && lstUsuarios.get(0).getId() != 0) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE + " (Email ja foi vinculado a outro Usuário).");
        }

        if (ibusiness.listarByFilter(entity, predFoneCelular).size() > 0) {
            getMessages().add(excMessages.STR_REG_JA_EXISTE + " (Telefone Celular já foi vinculado a outra Pessoa).");
        }
    }

    public void validarRegistroNaoCadastrado(Usuario entity, bsUsuario ibusiness) {
        Predicate<Usuario> predID = p -> p.getId().equals(entity.getId());
        if (ibusiness.listarByFilter(entity, predID).isEmpty()) {
            getMessages().add(excMessages.STR_REG_NAO_EXISTE);
        }
    }
}
