package com.app.service.business.bs.abstracts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.domain.model.core.Icore;
import com.app.domain.orm.core.Irepository;
import com.app.service.business.core.Ibusiness;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Rodolfo
 */
public abstract class bsGeneric<T> implements Ibusiness<T> {

    @Autowired
    private Irepository<T> iRepository;

    @Override
    public void create(T entity) {
        iRepository.create(entity);
    }

    @Override
    public T update(T entity) {
        return iRepository.update(entity);
    }

    @Override
    public void deletar(T entity) {
        iRepository.delete(entity);
    }

    @Override
    public void deletarById(T entity) {
        Icore core = (Icore) entity;
        iRepository.deleteById(core.getId());
    }

    @Override
    public T consultar(T entity) {
        Icore core = (Icore) entity;
        return iRepository.findById(core.getId());
    }

    @Override
    public List<T> listarAll() {
        return iRepository.findAll();
    }

    @Override
    public List<T> listarByFilter(T entity, Predicate<T> predicate) {
        return iRepository.findAll().stream().filter(predicate).collect(Collectors.toList());
    }
}
