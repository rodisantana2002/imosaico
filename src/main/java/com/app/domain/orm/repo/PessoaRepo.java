/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.repo;

import com.app.domain.model.pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepo extends JpaRepository<pessoa, Long> {
}
