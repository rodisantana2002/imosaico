package com.app.service.business.bs.abstracts;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Rodolfo
 */
//public abstract class bsGeneric<T> {
//
//    @Autowired
//    private Irepository<T> iRepository;
//
//    public void create(T entity) {
//        iRepository.create(entity);
//    }
//
//    public T update(T entity) {
//        return (T) iRepository.update(entity);
//    }
//
//    public void deletar(T entity) {
//        iRepository.delete(entity);
//    }
//
//    public void deletarById(T entity) {
//        Icore core = (Icore) entity;
//        iRepository.deleteById(core.getId());
//    }
//
//    public T consultar(T entity) {
//        Icore core = (Icore) entity;
//        return iRepository.findById(core.getId());
//    }
//
//    public List<T> listarAll() {
//        return iRepository.findAll();
//    }
//
//    public List<T> listarByFilter(T entity, Predicate<T> predicate) {
//        return (List<T>) iRepository.findAll().stream().filter(predicate).collect(Collectors.toList());
//    }
//}
