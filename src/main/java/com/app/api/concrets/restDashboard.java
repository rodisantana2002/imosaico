/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.api.concrets;

import com.app.domain.model.transitorio.Dashboard;
import com.app.helpers.excecoes.excEntityNotFoundException;
import com.app.helpers.types.clsMappingFilterUtils;
import com.app.service.controlls.controll.concrets.ctrlDashboard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@RestController
@RequestMapping("v1/dashboard")
public class restDashboard {

    @Autowired
    protected ctrlDashboard controll;

    @RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
    public @ResponseBody
    ResponseEntity<?> get() {
        Dashboard entity = this.controll.obter();

        if (entity == null) {
            throw new excEntityNotFoundException("Dados para o Dashboard não foram localizados!");
        }

        MappingJacksonValue mappingValue = clsMappingFilterUtils.applyFilter(entity, clsMappingFilterUtils.JsonFilterMode.EXCLUDE_FIELD_MODE, "Filtrar" + this.controll.toString(), "id", "dtregistro");
        return ResponseEntity.ok(mappingValue);
    }

}
