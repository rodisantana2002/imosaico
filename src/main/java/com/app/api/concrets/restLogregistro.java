/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.concrets;

import com.app.api.abstracts.restController;
import com.app.domain.model.Logregistro;
import com.app.helpers.excecoes.excEntityNotFoundException;
import com.app.helpers.types.clsMappingFilterUtils;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.PathVariable;
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
    ResponseEntity<?> listPages(
            HttpServletResponse response,
            @RequestParam(defaultValue = "0") Integer pageNo,
            @RequestParam(defaultValue = "10") Integer pageSize,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction,
            @RequestParam HashMap<String, String> allFilters
    ) {

        if (allFilters == null) {
            allFilters = new HashMap<>();
        }

        //Obter dados
        List<Logregistro> list = this.controll.obterTodosPage(pageNo, pageSize, sortBy, direction, allFilters);
        List<Logregistro> all = this.controll.obterTodos();

        if (list.isEmpty()) {
            throw new excEntityNotFoundException("Nenhum " + this.controll.toString() + " foi localizado!");
        }

        // prepara o Header
        Integer pageTotal = (all.size() / pageSize);
        if ((all.size() % pageSize) > 0) {
            pageTotal++;
        }

        response.addHeader("pageNo", String.valueOf(pageNo));
        response.addHeader("pageSize", String.valueOf(pageSize));
        response.addHeader("pageTotal", String.valueOf(pageTotal));
        response.addHeader("regsTotal", String.valueOf(all.size()));
        response.addHeader("sortBy", sortBy);
        response.addHeader("direction", direction);

        //aplica filtro para remover atributos do retorno
        MappingJacksonValue mappingValue = clsMappingFilterUtils.applyFilter(list, clsMappingFilterUtils.JsonFilterMode.EXCLUDE_FIELD_MODE, "Filtrar" + this.controll.toString(), "log");

        return ResponseEntity.ok(mappingValue);
    }

    @RequestMapping(value = "/{id}/log", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<?> getDetail(@PathVariable Long id) {
        Optional<Logregistro> entity = this.controll.obter(id);

        if (!entity.isPresent()) {
            throw new excEntityNotFoundException(this.controll.toString() + ":" + id + " não foi localizado!");
        }

        MappingJacksonValue mappingValue = clsMappingFilterUtils.applyFilter(entity.get().getLog(), clsMappingFilterUtils.JsonFilterMode.EXCLUDE_FIELD_MODE, "Filtrar" + this.controll.toString(), "");
        return ResponseEntity.ok(mappingValue);
    }
}
