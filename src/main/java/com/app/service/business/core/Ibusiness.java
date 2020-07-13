package com.app.service.business.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author Rodolfo
 */
public interface Ibusiness<T> {

    public abstract T create(T entity);

    public abstract T update(T entity);

    public abstract void deletar(T entity);

    public abstract void deletarById(T entity);

    public abstract Optional<T> consultar(T entity);

    public abstract List<T> listarAll();

    public abstract List<T> listarByFilter(T entity, Predicate<T> predicate);
}
