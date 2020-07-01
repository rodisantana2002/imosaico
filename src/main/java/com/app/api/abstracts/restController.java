/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.abstracts;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
import com.app.helpers.excecoes.excMessages;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class restController<T> {

    @Autowired
    private Icontroll<T> controll;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    List<T> listAll() {
        List<T> all = (List<T>) this.controll.obterTodos();
        return all;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    T get(@PathVariable Long id) {
        return this.controll.obter(id);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> create(@RequestBody T json) {
        List<String> msg = this.controll.salvar(json);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", true);
        m.put("msg", msg);
        return m;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> update(@PathVariable Long id, @RequestBody T json) {
        T entity = this.controll.obter(id);
        List<String> msg = new ArrayList<String>();
        String status;

        if (entity != null) {
            BeanUtils.copyProperties(entity, json);
            msg = this.controll.salvar(entity);
            status = "200 OK";
        } else {
            msg.add(excMessages.STR_REG_NAO_EXISTE);
            status = "404 = Not Found";
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", status);
        m.put("msg", msg);
        return m;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Map<String, Object> delete(@PathVariable Long id) {
        T entity = this.controll.obter(id);

        this.controll.deletar(entity);
        Map<String, Object> m = new HashMap<String, Object>();
        m.put("success", true);
        return m;
    }
}
