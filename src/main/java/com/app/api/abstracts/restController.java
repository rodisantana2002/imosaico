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
import com.app.helpers.excecoes.excViolacaoRegrasNegocio;
import com.app.helpers.types.clsMappingFilterUtils;
import com.app.service.controlls.core.Icontroll;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONObject;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
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

        //filtra e obtem dados
        List<T> list = this.controll.obterTodosPage(pageNo, pageSize, sortBy, direction, allFilters);
        List<T> all = this.controll.obterTodos();

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
        //limita fileds de retorno no Json conforme lista de fields informados
        MappingJacksonValue mappingValue = clsMappingFilterUtils.applyFilter(list, clsMappingFilterUtils.JsonFilterMode.EXCLUDE_FIELD_MODE, "Filtrar" + this.controll.toString(), "");

        return ResponseEntity.ok(mappingValue);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<?> get(@PathVariable Long id) {
        Optional<T> entity = this.controll.obter(id);

        if (!entity.isPresent()) {
            throw new excEntityNotFoundException(this.controll.toString() + ":" + id + " não foi localizado!");
        }

        MappingJacksonValue mappingValue = clsMappingFilterUtils.applyFilter(entity.get(), clsMappingFilterUtils.JsonFilterMode.EXCLUDE_FIELD_MODE, "Filtrar" + this.controll.toString(), "");
        return ResponseEntity.ok(mappingValue);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> create(@RequestBody T entity
    ) {
        List<String> msg = this.controll.salvar(entity);
        Map<String, Object> m = new HashMap<>();

        if (msg.contains("Status 400")) {
            List<String> msgs = new ArrayList<>();

            for (String var : msg) {
                msgs.add(var);
            }
            throw new excViolacaoRegrasNegocio(msgs.toString());
        }
        m.put("message", msg);
        m.put("status", "200");
        return m;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = {MediaType.APPLICATION_JSON_VALUE}, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> update(@PathVariable Long id, @RequestBody T entity
    ) {
        Optional<T> objTemp = this.controll.obter(id);
        JSONObject jsono = new JSONObject(entity);

        //verifica se os ids informados conferem
        if (jsono.getLong("id") != id) {
            throw new excEntityNotFoundException("Atributo Id [" + String.valueOf(jsono.getLong("id")) + "] informado no Json não confere com parametro Id passado na URL [" + id + "]");
        }

        List<String> msg = new ArrayList<>();

        if (objTemp.isPresent()) {
            BeanUtils.copyProperties(entity, objTemp.get());
            msg = this.controll.salvar(objTemp.get());

            if (msg.contains("Status 400")) {
                List<String> msgs = new ArrayList<>();

                for (String var : msg) {
                    msgs.add(var);
                }
                throw new excViolacaoRegrasNegocio(msgs.toString());
            }
        } else {
            throw new excEntityNotFoundException(this.controll.toString() + ":" + id + " não foi localizado!");
        }

        Map<String, Object> m = new HashMap<>();
        m.put("message", msg);
        m.put("status", "200");
        return m;
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    Map<String, Object> delete(@PathVariable Long id
    ) {
        Optional<T> entity = this.controll.obter(id);
        List<String> msg = new ArrayList<>();

        if (entity.isPresent()) {
            msg = this.controll.deletar(entity.get());

            if (msg.contains("Status 400")) {
                List<String> msgs = new ArrayList<>();

                for (String var : msg) {
                    msgs.add(var);
                }
                throw new excViolacaoRegrasNegocio(msgs.toString());
            }

        } else {
            throw new excEntityNotFoundException(this.controll.toString() + ":" + id + " não foi localizado!");
        }

        Map<String, Object> m = new HashMap<>();
        m.put("message", msg);
        m.put("status", "200");
        return m;
    }
}
