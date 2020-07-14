/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.core;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/**
 *
 * @author Rodolfo
 */
public interface Icontroll<T> {

    public abstract List<String> salvar(T entity);

    public abstract List<String> deletar(T entity);

    public abstract Optional<T> obter(Long id);

    public abstract List<T> obterTodos();

    public abstract List<T> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion);

    public abstract List<T> obterByFilter(T entity, Predicate<T> predicate);
}
