/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

/**
 *
 * @author Rodolfo //
 */
//public class ctrlPessoa implements Icontroll<pessoa> {
//
//    private Ibusiness ibusiness;
//    private Ivalidator<pessoa> ivalidator;
//    private List<String> msgs, regras;
//
//    public ctrlPessoa() {
//        ibusiness = new businessFactory<pessoa>(new pessoa()).getBusiness();
//        ivalidator = new validatorFactory<pessoa>(new pessoa()).getValidator();
//        msgs = new ArrayList<String>();
//        regras = new ArrayList<String>();
//    }
//
//    public List<String> salvar(pessoa entity) {
//        msgs = validar(entity);
//        if (msgs.isEmpty()) {
//            if (ibusiness.salvar(entity) != null) {
//                msgs.add(excMessages.STR_REG_AUTOR_SUCESSO);
//                return msgs;
//            }
//        }
//        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
//        return msgs;
//    }
//
//    ///metodo personalizado para poder salvar e recuperar a pessoa criada no momento
//    ///da criação de um novo usuário ---utilizar sommente para essa situação
//    public pessoa salvarByUser(pessoa entity) {
//        Predicate<pessoa> predEMail = p -> p.getEmail().equalsIgnoreCase(entity.getEmail());
//        List<pessoa> lstPessoas = ibusiness.listarByFilter(entity, predEMail);
//
//        if (!lstPessoas.isEmpty()) {
//            return (pessoa) lstPessoas.get(0);
//        }
//        return (pessoa) ibusiness.salvar(entity);
//    }
//
//    @Override
//    public List<String> deletar(pessoa entity) {
//        msgs = validarDelete(entity);
//        if (msgs.isEmpty()) {
//            if (ibusiness.deletar(entity)) {
//                msgs.add(excMessages.STR_DEL_AUTOR_SUCESSO);
//                return msgs;
//            }
//        }
//        msgs.add(excMessages.STR_OPERACAO_INSUCESSO);
//        return msgs;
//    }
//
//    @Override
//    public pessoa obter(Long id) {
//        pessoa p = new pessoa();
//        p.setId(id);
//        return (pessoa) ibusiness.consultar(p);
//    }
//
//    @Override
//    public List<pessoa> obterTodos() {
//        ArrayList<pessoa> listaPessoa = (ArrayList<pessoa>) ibusiness.listarAll(new pessoa());
//        return listaPessoa;
//    }
//
//    @Override
//    public List<pessoa> obterByFilter(pessoa entity, Predicate<pessoa> predicate) {
//        ArrayList<pessoa> listaPessoa = (ArrayList<pessoa>) ibusiness.listarByFilter(entity, predicate);
//        return listaPessoa;
//    }
//
//    private List<String> validarDelete(pessoa entity) {
//        if (entity.getId() != null) {
//            regras.add("validarPessoaNaoCadastrada");
//            regras.add("validarDocumentoVinculado");
//        }
//        return ivalidator.validarRegras(entity, regras);
//    }
//
//    private List<String> validar(pessoa entity) {
//        regras.add("validarCamposObrigatorios");
//        if (entity.getId() == null) {
//            regras.add("validarPessoaCadastrada");
//        } else {
//            regras.add("validarPessoaNaoCadastrada");
//        }
//        return ivalidator.validarRegras(entity, regras);
//    }
//}
