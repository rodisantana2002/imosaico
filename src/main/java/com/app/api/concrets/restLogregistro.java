/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.concrets;

import com.app.api.abstracts.restController;
import com.app.domain.model.Logregistro;
import com.app.helpers.excecoes.excEntityNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@RestController
@RequestMapping("v1/logs")
public class restLogregistro extends restController<Logregistro> {

    public restLogregistro() {
        super();
    }

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    Map<String, Object> listPages(
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {
        List<Logregistro> list = this.controll.obterTodosPage(pageNo, pageSize, sortBy, direction);
        List<Logregistro> all = this.controll.obterTodos();

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
}
