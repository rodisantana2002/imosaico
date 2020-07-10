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
import com.app.service.business.core.Ivalidator;
import com.app.service.business.factory.validatorFactory;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.List;
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
    private Ivalidator<Usuario> ivalidatorUsuario;
    private ctrlPessoa ctrlPessoa;
    private List<String> msgs, regras;

    public ctrlUsuario() {
        ivalidatorUsuario = new validatorFactory<Usuario>(new Usuario()).getValidator();
        ctrlPessoa = new ctrlPessoa();
        msgs = new ArrayList<String>();
        regras = new ArrayList<String>();
    }

    @Override
    public List<String> salvar(Usuario entity) {
        List<String> msgs = new ArrayList<String>();
        msgs = validarUsuario(entity);

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
    public Usuario obter(Long id) {
        Usuario u = new Usuario();
        u.setId(id);
        return (Usuario) ibusiness.consultar(u);
    }

    @Override
    public List<Usuario> obterTodos() {
        return ibusiness.listarAll();
    }

    @Override
    public List<Usuario> obterByFilter(Usuario entity, Predicate<Usuario> predicate) {
        return ibusiness.listarByFilter(entity, predicate);
    }

    private List<String> validarDelete(Usuario entity) {
        if (entity.getId() != null) {
            regras.add("validarRegistroNaoCadastrado");
        }
        return ivalidatorUsuario.validarRegras(entity, regras, ibusiness);
    }

    private List<String> validarUsuario(Usuario entity) {
        regras.add("validarCamposObrigatorios");
        if (entity.getId() == null) {
            regras.add("validarRegistroCadastrado");
        } else {
            regras.add("validarRegistroNaoCadastrado");
        }
        return ivalidatorUsuario.validarRegras(entity, regras, ibusiness);
    }

    @Override
    public List<String> deletar(Usuario entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

//    public List<String> autenticarUsuario(Usuario entity) {
//        regras.add("validarAutenticacaoUsuario");
//        return ivalidatorUsuario.validarRegras(entity, regras, ibusiness);
//    }
//
//    public List<String> autenticarToken(Usuario entity) {
//        regras.add("validarTokenUsuario");
//        return ivalidatorUsuario.validarRegras(entity, regras, ibusiness);
//    }
//
//    public Usuario atualizarToken(Usuario entity) {
//        Random random = new SecureRandom();
//        String token = new BigInteger(130, random).toString(32);
//        Date dtDataHoraAtual = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Predicate<Usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(entity.getPessoa().getEmail());
//
//        List<Usuario> lstUsuario = obterByFilter(entity, predEMail);
//        Usuario Usuario = lstUsuario.get(0);
//        Usuario.setToken(token);
//        salvar(Usuario);
//        Usuario.setSenha("");
//        return Usuario;
//    }
//    public void efetuarLogout(Usuario entity) {
//        Predicate<Usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(entity.getPessoa().getEmail());
//
//        List<Usuario> lstUsuario = obterByFilter(entity, predEMail);
//        Usuario Usuario = lstUsuario.get(0);
//        Usuario.setToken(null);
//        salvar(Usuario);
//    }
//    public String enviarSenha(String email) {
//        Predicate<Usuario> predEMail = p -> p.getPessoa().getEmail().equals(email);
//
//        Usuario Usuario = new Usuario();
//        Pessoa pessoa = new Pessoa();
//        pessoa.setEmail(email);
//        Usuario.setPessoa(pessoa);
//
//        List<Usuario> lstUsuario = obterByFilter(Usuario, predEMail);
//
//        if (lstUsuario.isEmpty()) {
//            return excMessages.STR_EMAIL_NAO_CADASTRADO;
//        } else {
//            clsTrataEmail trataEmail = new clsTrataEmail();
//            String endereco = email;
//            String assunto = "Sistema Papers - reenvio de dados para acesso ao sistema";
//            String conteudo = getEmailCorpo(lstUsuario.get(0)).toString();
//            return trataEmail.enviarEmail(endereco, assunto, conteudo);
//        }
//    }
//
//    private StringBuilder getEmailCorpo(Usuario Usuario) {
//        StringBuilder emailCorpo = new StringBuilder();
//        emailCorpo.append("<h1>Olá, " + Usuario.getPessoa().getNomecompleto() + "!</h1>");
//        emailCorpo.append("</br>");
//        emailCorpo.append("<h3>Seguem os dados para o acesso ao sistema Papers: </h3>");
//        emailCorpo.append("<h4>Usuário...: " + Usuario.getPessoa().getEmail() + "</h4>");
//        emailCorpo.append("<h4>Senha.....: " + Usuario.getSenha() + "</h4>");
//        emailCorpo.append("</br>");
//        emailCorpo.append("</h4>Att, </h4>");
//        emailCorpo.append("</br>");
//        emailCorpo.append("</h4>Equipe Papers </h4>");
//        return emailCorpo;
//    }
