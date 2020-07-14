/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Pessoa;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsPessoa;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.List;
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
public class ctrlPessoa implements Icontroll<Pessoa> {

    @Autowired
    private bsPessoa ibusiness;

    public ctrlPessoa() {
    }

    public List<String> salvar(Pessoa entity) {
        List<String> msgs = new ArrayList<String>();
//        msgs = validar(entity);

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

    ///metodo personalizado para poder salvar e recuperar a Pessoa criada no momento
    ///da criação de um novo usuário ---utilizar sommente para essa situação
    public Pessoa salvarByUser(Pessoa entity) {
        Predicate<Pessoa> predEMail = p -> p.getEmail().equalsIgnoreCase(entity.getEmail());
        List<Pessoa> lstPessoas = ibusiness.listarByFilter(entity, predEMail);

        if (!lstPessoas.isEmpty()) {
            return lstPessoas.get(0);
        }

        ibusiness.create(entity);
        lstPessoas = ibusiness.listarByFilter(entity, predEMail);
        return lstPessoas.get(0);
    }

    @Override
    public List<String> deletar(Pessoa entity) {
//        List<String> msgs = validarDelete(entity);
//
//        if (msgs.isEmpty()) {
//            deletar(entity);
//            msgs.add(excMessages.STR_DEL_PESSOA_SUCESSO);
//            return msgs;
//        }
//        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
//        return msgs;
        return null;
    }

    @Override
    public Optional<Pessoa> obter(Long id) {
        Pessoa p = new Pessoa();
        p.setId(id);
        return ibusiness.consultar(p);
    }

    @Override
    public List<Pessoa> obterTodos() {
        ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) ibusiness.listarAll();
        return listaPessoa;
    }

    @Override
    public List<Pessoa> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Pessoa> obterByFilter(Pessoa entity, Predicate<Pessoa> predicate) {
        ArrayList<Pessoa> listaPessoa = (ArrayList<Pessoa>) ibusiness.listarByFilter(entity, predicate);
        return listaPessoa;
    }
//
//    private List<String> validarDelete(Pessoa entity) {
//        List<String> regras = new ArrayList<String>();
//
//        if (entity.getId() != null) {
//            regras.add("validarPessoaNaoCadastrada");
//        }
//        return ivalidator.validarRegras(entity, regras, ibusiness);
//    }
//
//    private List<String> validar(Pessoa entity) {
//        List<String> regras = new ArrayList<String>();
//        regras.add("validarCamposObrigatorios");
//
//        if (entity.getId() == null) {
//            regras.add("validarPessoaCadastrada");
//        } else {
//            regras.add("validarPessoaNaoCadastrada");
//        }
//        return ivalidator.validarRegras(entity, regras, ibusiness);
//    }

    @Override
    public String toString() {
        return "Pessoa";
    }

}
