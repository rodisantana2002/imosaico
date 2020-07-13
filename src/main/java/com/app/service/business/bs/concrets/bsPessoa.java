/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.business.bs.concrets;

import com.app.domain.model.Pessoa;
import com.app.domain.model.core.Icore;
import com.app.domain.orm.repo.repoPessoa;
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
 * @author Rodolfo
 */
@Service
@Transactional
public class bsPessoa implements Ibusiness<Pessoa> {

    @Autowired
    private repoPessoa iRepository;

    @Override
    public Pessoa create(Pessoa entity) {
        return iRepository.save(entity);
    }

    @Override
    public Pessoa update(Pessoa entity) {
        return iRepository.save(entity);
    }

    @Override
    public void deletar(Pessoa entity) {
        iRepository.delete(entity);
    }

    @Override
    public void deletarById(Pessoa entity) {
        Icore core = (Icore) entity;
        iRepository.deleteById(core.getId());
    }

    @Override
    public Optional<Pessoa> consultar(Pessoa entity) {
        Icore core = (Icore) entity;
        return iRepository.findById(core.getId());
    }

    @Override
    public List<Pessoa> listarByFilter(Pessoa entity, Predicate<Pessoa> predicate) {
        List<Pessoa> lstDados = (List<Pessoa>) iRepository.findAll();
        return lstDados.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public List<Pessoa> listarAll() {
        return (List<Pessoa>) iRepository.findAll();
    }
}
