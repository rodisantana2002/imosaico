/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.core;

import java.util.List;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public interface Irepository<T> {

    T findById(final long id);

    List<T> findAll();

    void create(final T entity);

    T update(final T entity);

    void delete(final T entity);

    void deleteById(final long entityId);

}
