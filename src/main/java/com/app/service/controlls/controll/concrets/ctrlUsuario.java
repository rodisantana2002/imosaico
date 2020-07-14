/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Pessoa;
import com.app.domain.model.Usuario;
import com.app.helpers.excecoes.excMessages;
import com.app.service.business.bs.concrets.bsUsuario;
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
 * // * @author Rodolfo //
 */
@Service
@Transactional
public class ctrlUsuario implements Icontroll<Usuario> {

    @Autowired
    private bsUsuario ibusiness;
    private ctrlPessoa ctrlPessoa;
    private List<String> msgs, regras;

    public ctrlUsuario() {
        ctrlPessoa = new ctrlPessoa();
        msgs = new ArrayList<String>();
        regras = new ArrayList<String>();
    }

    @Override
    public List<String> salvar(Usuario entity) {
        List<String> msgs = new ArrayList<String>();
//        msgs = validarUsuario(entity);

        if (msgs.isEmpty()) {
            //se tudo ok..vai avaliar se precisa criar uma nova pessoa
            Pessoa pessoa = (Pessoa) ctrlPessoa.salvarByUser(entity.getPessoa());

            if (pessoa != null) {
                entity.setPessoa(pessoa);
                ibusiness.create(entity);
                msgs.add(excMessages.STR_REG_USUARIO_SUCESSO);
                return msgs;
            }
        }
        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
        return msgs;
    }

    @Override
    public Optional<Usuario> obter(Long id) {
        Usuario u = new Usuario();
        u.setId(id);
        return ibusiness.consultar(u);
    }

    @Override
    public List<Usuario> obterTodos() {
        return ibusiness.listarAll();
    }

    @Override
    public List<Usuario> obterByFilter(Usuario entity, Predicate<Usuario> predicate) {
        return ibusiness.listarByFilter(entity, predicate);
    }

    public Usuario obterByEmail(String email) {
        Predicate<Usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(email);
        Usuario entity = new Usuario();
        entity.getPessoa().setEmail(email);
        return ibusiness.listarByFilter(entity, predEMail).stream().findFirst().orElse(null);
    }
//
//    private List<String> validarDelete(Usuario entity) {
//        if (entity.getId() != null) {
//            regras.add("validarRegistroNaoCadastrado");
//        }
//        return ivalidatorUsuario.validarRegras(entity, regras, ibusiness);
//    }
//
//    private List<String> validarUsuario(Usuario entity) {
//        regras.add("validarCamposObrigatorios");
//        if (entity.getId() == null) {
//            regras.add("validarRegistroCadastrado");
//        } else {
//            regras.add("validarRegistroNaoCadastrado");
//        }
//        return ivalidatorUsuario.validarRegras(entity, regras, ibusiness);
//    }

    @Override
    public List<String> deletar(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Usuário";
    }

    @Override
    public List<Usuario> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
