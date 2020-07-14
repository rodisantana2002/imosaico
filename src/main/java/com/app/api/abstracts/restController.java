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
import com.app.helpers.excecoes.excEntityNotFoundExcpetion;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

public abstract class restController<T> {

    @Autowired
    protected Icontroll<T> controll;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> listPages(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        List<T> list = this.controll.obterTodosPage(pageNo, pageSize, sortBy, direction);
        List<T> all = this.controll.obterTodos();

        if (list.isEmpty()) {
            throw new excEntityNotFoundExcpetion("Nenhum " + this.controll.toString() + " foi localizado!");
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", "200");
        m.put("PageNo", pageNo);
        m.put("PageSize", pageSize);
        m.put("SortBy", sortBy);
        m.put("Direction", direction);
        m.put("PageTotal", Integer.divideUnsigned(all.size(), pageSize));
        m.put(this.controll.toString(), list);
        return m;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    T get(@PathVariable Long id) {
        T entity = (T) this.controll.obter(id);
        if (entity == null) {
            throw new excEntityNotFoundExcpetion(this.controll.toString() + ":" + id + " não foi localizado!");
        }
        return entity;
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> create(@RequestBody T json
    ) {
        List<String> msg = this.controll.salvar(json);

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", "201");
        m.put("msg", msg);
        return m;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> update(@PathVariable Long id,
            @RequestBody T json
    ) {
        T entity = (T) this.controll.obter(id);
        List<String> msg = new ArrayList<String>();
        String status;

        if (entity != null) {
            BeanUtils.copyProperties(json, entity);
            msg = this.controll.salvar(entity);
            status = "200 OK";
        } else {
            msg.add(excMessages.STR_REG_NAO_EXISTE);
            status = "404 - " + this.controll.toString() + ":" + id + " não foi localizado!";
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", status);
        m.put("msg", msg);
        return m;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Map<String, Object> delete(@PathVariable Long id
    ) {
        T entity = (T) this.controll.obter(id);
        List<String> msg = new ArrayList<String>();
        String status;

        if (entity != null) {
            this.controll.deletar(entity);
            Map<String, Object> m = new HashMap<String, Object>();
            m.put(this.controll.toString() + ":" + id + " foi deletado com sucesso!", true);
            status = "204 OK";
        } else {
            msg.add(excMessages.STR_REG_NAO_EXISTE);
            status = "404 - " + this.controll.toString() + ":" + id + " não foi localizado!";
        }

        Map<String, Object> m = new HashMap<String, Object>();
        m.put("status", status);
        m.put("msg", msg);
        return m;
    }
}
