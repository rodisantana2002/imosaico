/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.bs.concrets;

import com.app.domain.model.Usuario;
import com.app.domain.model.core.Icore;
import com.app.domain.orm.repo.repoUsuario;
import com.app.service.business.core.Ibusiness;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Service
@Transactional
public class bsUsuario implements Ibusiness<Usuario> {

    @Autowired
    private repoUsuario iRepository;

    @Override
    public Usuario create(Usuario entity) {
        return iRepository.save(entity);
    }

    @Override
    public Usuario update(Usuario entity) {
        return iRepository.save(entity);
    }

    @Override
    public void deletar(Usuario entity) {
        iRepository.delete(entity);
    }

    @Override
    public void deletarById(Usuario entity) {
        Icore core = (Icore) entity;
        iRepository.deleteById(core.getId());
    }

    @Override
    public Optional<Usuario> consultar(Usuario entity) {
        Icore core = (Icore) entity;
        return iRepository.findById(core.getId());
    }

    @Override
    public List<Usuario> listarByFilter(Usuario entity, Predicate<Usuario> predicate) {
        List<Usuario> lstDados = (List<Usuario>) iRepository.findAll();
        return lstDados.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Usuario> listarAll() {
        return (List<Usuario>) iRepository.findAll();
    }

//    @Autowired
//    private Irepository<Usuario> Dao;
//
//    public bsUsuario() {
//        super();
//    }
}
