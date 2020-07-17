/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model.core;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@MappedSuperclass
public abstract class Core<T> implements Serializable, Icore<T> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dtregistro;

    @PrePersist
    public void preInsert() {
        SimpleDateFormat fmt = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        if (dtregistro == null) {
            dtregistro = fmt.format(new Date());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDtregistro() {
        return dtregistro;
    }

    public void setDtregistro(String dtregistro) {
        this.dtregistro = dtregistro;
    }

}
