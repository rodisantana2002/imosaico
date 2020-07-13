/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.bs.concrets;

import com.app.domain.model.Sistema;
import com.app.domain.model.core.Icore;
import com.app.domain.orm.repo.repoSistema;
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
public class bsSistema implements Ibusiness<Sistema> {

    @Autowired
    private repoSistema iRepository;

    @Override
    public Sistema create(Sistema entity) {
        return iRepository.save(entity);
    }

    @Override
    public Sistema update(Sistema entity) {
        return iRepository.save(entity);
    }

    @Override
    public void deletar(Sistema entity) {
        iRepository.delete(entity);
    }

    @Override
    public void deletarById(Sistema entity) {
        Icore core = (Icore) entity;
        iRepository.deleteById(core.getId());
    }

    @Override
    public Optional<Sistema> consultar(Sistema entity) {
        Icore core = (Icore) entity;
        return iRepository.findById(core.getId());
    }

    @Override
    public List<Sistema> listarByFilter(Sistema entity, Predicate<Sistema> predicate) {
        List<Sistema> lstDados = (List<Sistema>) iRepository.findAll();
        return lstDados.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Sistema> listarAll() {
        return (List<Sistema>) iRepository.findAll();
    }
//
//    @Autowired
//    private Irepository<Sistema> Dao;
//
//    public bsSistema() {
//        super();
//    }

}
