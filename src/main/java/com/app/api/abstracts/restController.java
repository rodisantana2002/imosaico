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
import com.app.helpers.excecoes.excEntityNotFoundException;
import com.app.helpers.excecoes.excMessages;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam HashMap<String, String> allFilters
    ) {
        if (allFilters == null) {
            allFilters = new HashMap<String, String>();
        }
        List<T> list = this.controll.obterTodosPage(pageNo, pageSize, sortBy, direction, allFilters);
        List<T> all = this.controll.obterTodos();

        if (list.isEmpty()) {
            throw new excEntityNotFoundException("Nenhum " + this.controll.toString() + " foi localizado!");
        }

        Map<String, Object> m = new HashMap<>();
        m.put("status", "200");
        m.put("PageNo", pageNo);
        m.put("PageSize", pageSize);
        m.put("SortBy", sortBy);
        m.put("Direction", direction);
        m.put("PageTotal", Integer.divideUnsigned(all.size(), pageSize));
        m.put(this.controll.toString() + "s", list);
        return m;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    T get(@PathVariable Long id) {
        Optional<T> entity = this.controll.obter(id);

        if (!entity.isPresent()) {
            throw new excEntityNotFoundException(this.controll.toString() + ":" + id + " não foi localizado!");
        }
        return entity.get();
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> create(@RequestBody T json
    ) {
        List<String> msg = this.controll.salvar(json);
        Map<String, Object> m = new HashMap<>();
        m.put("status", "201");
        m.put("msg", msg);
        return m;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> update(@PathVariable Long id,
            @RequestBody T json
    ) {
        Optional<T> entity = this.controll.obter(id);

        List<String> msg = new ArrayList<>();
        String status;

        if (entity.isPresent()) {
            BeanUtils.copyProperties(json, entity);
            msg = this.controll.salvar(entity.get());
            status = "200 OK";
        } else {
            msg.add(excMessages.STR_REG_NAO_EXISTE);
            status = "404 - " + this.controll.toString() + ":" + id + " não foi localizado!";
        }

        Map<String, Object> m = new HashMap<>();
        m.put("status", status);
        m.put("msg", msg);
        return m;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    Map<String, Object> delete(@PathVariable Long id
    ) {
        Optional<T> entity = this.controll.obter(id);
        List<String> msg = new ArrayList<>();
        String status;

        if (entity.isPresent()) {
            this.controll.deletar(entity.get());
            Map<String, Object> m = new HashMap<>();
            m.put(this.controll.toString() + ":" + id + " foi deletado com sucesso!", true);
            status = "204 OK";
        } else {
            msg.add(excMessages.STR_REG_NAO_EXISTE);
            status = "404 - " + this.controll.toString() + ":" + id + " não foi localizado!";
        }

        Map<String, Object> m = new HashMap<>();
        m.put("status", status);
        m.put("msg", msg);
        return m;
    }
}
