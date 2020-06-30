package com.app.service.business.core;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.app.service.business.bs.abstracts.bsGeneric;
import java.util.List;

/**
 *
 * @author Rodolfo
 */
public interface Ivalidator<T> {

    public abstract List<String> validarRegras(T entity, String operacao, bsGeneric bs);

    public abstract List<String> validarRegras(T entity, List<String> operacao, bsGeneric bs);
}
