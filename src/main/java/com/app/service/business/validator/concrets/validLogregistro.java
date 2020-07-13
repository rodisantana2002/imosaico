/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.validator.concrets;

import com.app.domain.model.Logregistro;
import com.app.service.business.bs.concrets.bsLogregistro;
import com.app.service.business.validator.abstracts.validGeneric;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public class validLogregistro extends validGeneric<Logregistro> {

    public validLogregistro() {
        super();
    }

    public void validarCamposObrigatorios(Logregistro entity, bsLogregistro ibusiness) {
//        if (entity.getId() != null && entity.getId() == 0) {
//            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Identificador" + ").");
//        }
//        if (entity.getNomecompleto() == null || entity.getNomecompleto().trim().isEmpty()) {
//            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Nome completo" + ").");
//        }
//        if (entity.getEmail() == null || entity.getEmail().trim().isEmpty()) {
//            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Email" + ").");
//        }
//
//        if (entity.getFonecelular() == null || entity.getFonecelular().trim().isEmpty()) {
//            getLstMsg().add(excMessages.STR_DADOS_OBRIGATORIOS + " - (" + "Telefone Celular" + ").");
//        }
    }

    public void validarLogregistroCadastrada(Logregistro entity, bsLogregistro ibusiness) {
//        Predicate<Logregistro> predID = p -> p.getId().equals(entity.getId());
//        Predicate<Logregistro> predEMail = p -> p.getEmail().equalsIgnoreCase(entity.getEmail());
//        Predicate<Logregistro> predFoneCelular = p -> p.getFonecelular().equals(entity.getFonecelular());
//
//        if (ibusiness.listarByFilter(entity, predID).size() > 0) {
//            getLstMsg().add(excMessages.STR_REG_JA_EXISTE);
//        }
//
//        if (ibusiness.listarByFilter(entity, predEMail).size() > 0) {
//            getLstMsg().add(excMessages.STR_REG_JA_EXISTE + " (Email já foi vinculado a outra Logregistro).");
//        }
//
//        if (ibusiness.listarByFilter(entity, predFoneCelular).size() > 0) {
//            getLstMsg().add(excMessages.STR_REG_JA_EXISTE + " (Telefone Celular já foi vinculado a outra Logregistro).");
//        }
    }

    public void validarLogregistroNaoCadastrada(Logregistro entity, bsLogregistro ibusiness) {
//        Predicate<Logregistro> predID = p -> p.getId().equals(entity.getId());
//        if (ibusiness.listarByFilter(entity, predID).isEmpty()) {
//            getLstMsg().add(excMessages.STR_REG_NAO_EXISTE);
//        }
    }
}
