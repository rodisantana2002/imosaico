/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.repo;

import com.app.domain.model.Sistema;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Repository("repoSistema")
public interface repoSistema extends PagingAndSortingRepository<Sistema, Long> {
}

//@Repository("repoSistema")
//public class repoSistema extends repoGeneric<Sistema> implements Irepository<Sistema> {
//
//    public repoSistema() {
//        super();
//        setClazz(Sistema.class);
//    }
//
//}
