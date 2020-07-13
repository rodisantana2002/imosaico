/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.bs.concrets;

import com.app.domain.model.Logregistro;
import com.app.domain.model.core.Icore;
import com.app.domain.orm.repo.repoLogregistro;
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
public class bsLogregistro implements Ibusiness<Logregistro> {

    @Autowired
    private repoLogregistro iRepository;

    @Override
    public Logregistro create(Logregistro entity) {
        return iRepository.save(entity);
    }

    @Override
    public Logregistro update(Logregistro entity) {
        return iRepository.save(entity);
    }

    @Override
    public void deletar(Logregistro entity) {
        iRepository.delete(entity);
    }

    @Override
    public void deletarById(Logregistro entity) {
        Icore core = (Icore) entity;
        iRepository.deleteById(core.getId());
    }

    @Override
    public Optional<Logregistro> consultar(Logregistro entity) {
        Icore core = (Icore) entity;
        return iRepository.findById(core.getId());
    }

    @Override
    public List<Logregistro> listarByFilter(Logregistro entity, Predicate<Logregistro> predicate) {
        List<Logregistro> lstDados = (List<Logregistro>) iRepository.findAll();
        return lstDados.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Logregistro> listarAll() {
        return (List<Logregistro>) iRepository.findAll();
    }
}
