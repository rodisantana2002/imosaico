/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

/**
 *
 * // * @author Rodolfo //
 */
//public class ctrlUsuario implements Icontroll<usuario> {
//
//    private Ivalidator<usuario> ivalidatorUsuario;
//    private ctrlPessoa ctrlPessoa;
//    private List<String> msgs, regras;
//    private Ibusiness ibusiness;
//
//    public ctrlUsuario() {
//        ibusiness = new businessFactory<usuario>(new usuario()).getBusiness();
//        ivalidatorUsuario = new validatorFactory<usuario>(new usuario()).getValidator();
//        ctrlPessoa = new ctrlPessoa();
//        msgs = new ArrayList<String>();
//        regras = new ArrayList<String>();
//    }
//
//    @Override
//    public List<String> salvar(usuario entity) {
//        msgs = validarUsuario(entity);
//        if (msgs.isEmpty()) {
//            //se tudo ok..vai avaliar se precisa criar uma nova pessoa
//            pessoa pessoa = (pessoa) ctrlPessoa.salvarByUser(entity.getPessoa());
//
//            if (pessoa != null) {
//                entity.setPessoa(pessoa);
//                if (ibusiness.salvar(entity) != null) {
//                    msgs.add(excMessages.STR_REG_USUARIO_SUCESSO);
//                    return msgs;
//                } else {
//                    ctrlPessoa.deletar(pessoa);
//                }
//            }
//        }
//        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
//        return msgs;
//    }
//
//    @Override
//    public usuario obter(Long id) {
//        usuario u = new usuario();
//        u.setId(id);
//        return (usuario) ibusiness.consultar(u);
//    }
//
//    @Override
//    public List<usuario> obterTodos() {
//        return ibusiness.listarAll(new usuario());
//    }
//
//    @Override
//    public List<usuario> obterByFilter(usuario entity, Predicate<usuario> predicate) {
//        return ibusiness.listarByFilter(entity, predicate);
//    }
//
//    private List<String> validarDelete(usuario entity) {
//        if (entity.getId() != null) {
//            regras.add("validarRegistroNaoCadastrado");
//        }
//        return ivalidatorUsuario.validarRegras(entity, regras);
//    }
//
//    private List<String> validarUsuario(usuario entity) {
//        regras.add("validarCamposObrigatorios");
//        if (entity.getId() == null) {
//            regras.add("validarRegistroCadastrado");
//        } else {
//            regras.add("validarRegistroNaoCadastrado");
//        }
//        return ivalidatorUsuario.validarRegras(entity, regras);
//    }
//
//    public List<String> autenticarUsuario(usuario entity) {
//        regras.add("validarAutenticacaoUsuario");
//        return ivalidatorUsuario.validarRegras(entity, regras);
//    }
//
//    public List<String> autenticarToken(usuario entity) {
//        regras.add("validarTokenUsuario");
//        return ivalidatorUsuario.validarRegras(entity, regras);
//    }
//
//    public usuario atualizarToken(usuario entity) {
//        Random random = new SecureRandom();
//        String token = new BigInteger(130, random).toString(32);
//        Date dtDataHoraAtual = new Date();
//        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
//        Predicate<usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(entity.getPessoa().getEmail());
//
//        List<usuario> lstUsuario = obterByFilter(entity, predEMail);
//        usuario usuario = lstUsuario.get(0);
//        usuario.setToken(token);
//        salvar(usuario);
//        usuario.setSenha("");
//        return usuario;
//    }
//
//    public void efetuarLogout(usuario entity) {
//        Predicate<usuario> predEMail = p -> p.getPessoa().getEmail().equalsIgnoreCase(entity.getPessoa().getEmail());
//
//        List<usuario> lstUsuario = obterByFilter(entity, predEMail);
//        usuario usuario = lstUsuario.get(0);
//        usuario.setToken(null);
//        salvar(usuario);
//    }
//
//    public String enviarSenha(String email) {
//        Predicate<usuario> predEMail = p -> p.getPessoa().getEmail().equals(email);
//
//        usuario usuario = new usuario();
//        pessoa pessoa = new pessoa();
//        pessoa.setEmail(email);
//        usuario.setPessoa(pessoa);
//
//        List<usuario> lstUsuario = obterByFilter(usuario, predEMail);
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
//    private StringBuilder getEmailCorpo(usuario usuario) {
//        StringBuilder emailCorpo = new StringBuilder();
//        emailCorpo.append("<h1>Olá, " + usuario.getPessoa().getNomecompleto() + "!</h1>");
//        emailCorpo.append("</br>");
//        emailCorpo.append("<h3>Seguem os dados para o acesso ao sistema Papers: </h3>");
//        emailCorpo.append("<h4>Usuário...: " + usuario.getPessoa().getEmail() + "</h4>");
//        emailCorpo.append("<h4>Senha.....: " + usuario.getSenha() + "</h4>");
//        emailCorpo.append("</br>");
//        emailCorpo.append("</h4>Att, </h4>");
//        emailCorpo.append("</br>");
//        emailCorpo.append("</h4>Equipe Papers </h4>");
//        return emailCorpo;
//    }
//
//    @Override
//    public List<String> deletar(usuario entity) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//}
