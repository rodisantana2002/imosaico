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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

    @Override
    public List<Sistema> listarAll(Integer pageNo, Integer pageSize, String sortBy, String direction) {
        Pageable paging;
        if (direction.equals("desc")) {
            paging = (Pageable) PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        } else {
            paging = (Pageable) PageRequest.of(pageNo, pageSize, Sort.by(sortBy).ascending());
        }

        Page<Sistema> pagedResult = iRepository.findAll(paging);

        if (pagedResult.hasContent()) {
            return (List<Sistema>) pagedResult.getContent();
        } else {
            return new ArrayList<Sistema>();
        }
    }
}
