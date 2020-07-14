/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.repo;

import com.app.domain.model.Pessoa;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Repository("repoPessoa")
public interface repoPessoa extends PagingAndSortingRepository<Pessoa, Long> {
}
