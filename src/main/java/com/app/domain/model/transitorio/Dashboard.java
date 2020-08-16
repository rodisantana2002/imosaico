/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.model.transitorio;

import com.app.domain.model.core.Core;
import com.fasterxml.jackson.annotation.JsonFilter;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
@JsonFilter("FiltrarDashboard")
public class Dashboard extends Core {

    private Integer totalSistemas;
    private Integer totalGeralLogs;
    private Map<String, Long> totalPorSistema;
    private Map<String, Long> totalPorTipo;

    public Dashboard() {
        this.totalSistemas = 0;
        this.totalGeralLogs = 0;
        this.totalPorSistema = new HashMap<>();
        this.totalPorTipo = new HashMap<>();
    }

    public Integer getTotalGeralLogs() {
        return totalGeralLogs;
    }

    public void setTotalGeralLogs(Integer totalGeralLogs) {
        this.totalGeralLogs = totalGeralLogs;
    }

    public Map<String, Long> getTotalPorSistema() {
        return totalPorSistema;
    }

    public void setTotalPorSistema(Map<String, Long> totalPorSistema) {
        this.totalPorSistema = totalPorSistema;
    }

    public Map<String, Long> getTotalPorTipo() {
        return totalPorTipo;
    }

    public void setTotalPorTipo(Map<String, Long> totalPorTipo) {
        this.totalPorTipo = totalPorTipo;
    }

    public Integer getTotalSistemas() {
        return totalSistemas;
    }

    public void setTotalSistemas(Integer totalSistemas) {
        this.totalSistemas = totalSistemas;
    }
}
