/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helpers.factoryClassGeneric;

/**
 *
 * @author Rodolfo
 */
public class concretClassFactory<T> {

    private T entity;
    private String strNameClass;

    public concretClassFactory() {
    }

    public concretClassFactory(T entity) {
        this.entity = entity;
    }

    public T getFactoryValidator() {
        strNameClass = "com.app.service.business.validator.concrets.valid" + entity.getClass().getSimpleName();
        return getClass(strNameClass);
    }

    private T getClass(String strPath) {
        try {
            return getInstances(strPath);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private T getInstances(String strNameClass) {
        try {
            return (T) Class.forName(strNameClass).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
