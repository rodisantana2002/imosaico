/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.service.controlls.controll.concrets;

import com.app.domain.model.Logregistro;
import com.app.domain.model.Sistema;
import com.app.domain.model.transitorio.Dashboard;
import com.app.service.controlls.core.Icontroll;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@Service
@Transactional
public class ctrlDashboard implements Icontroll<Dashboard> {

    @Autowired
    private ctrlLogregistro logregistro;
    @Autowired
    private ctrlSistema sistema;

    @Override
    public List<String> salvar(Dashboard entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<String> deletar(Dashboard entity) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Dashboard> obter(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Dashboard obter() {
        Dashboard dashboard = new Dashboard();
        List<Logregistro> logs = logregistro.obterTodos();
        List<Sistema> sistemas = sistema.obterTodos();
        Map<String, Long> mapTipos = new HashMap<>();
        //------------------------------------------------------------------------------------------
        mapTipos.put("Info", logs.stream().filter(p -> p.getTipo().getDescricao().equals("Info")).count());
        mapTipos.put("Warning", logs.stream().filter(p -> p.getTipo().getDescricao().equals("Warning")).count());
        mapTipos.put("Error", logs.stream().filter(p -> p.getTipo().getDescricao().equals("Error")).count());
        
        dashboard.setTotalSistemas(sistemas.size());
        dashboard.setTotalGeralLogs(logs.size());
        dashboard.setTotalPorTipo(mapTipos);

        return dashboard;
    }

    @Override
    public List<Dashboard> obterTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dashboard> obterTodosPage(Integer pageNo, Integer pageSize, String sortBy, String diretion, Map<String, String> allFilters) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Dashboard> obterByFilter(Dashboard entity, Predicate<Dashboard> predicate) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Dashboard";
    }
}
