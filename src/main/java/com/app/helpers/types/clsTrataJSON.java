/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helpers.types;

import com.app.domain.model.transitorio.modElemento;
import java.util.List;

/**
 *
 * @author Rodolfo
 */
public class clsTrataJSON {

    private StringBuilder strBuilder;

    public String getJSON(List<modElemento> lstElements) {
        strBuilder = new StringBuilder();

        strBuilder.append("{");
        for (int i = 0; i <= (lstElements.size() - 1); i++) {
            strBuilder.append('"' + lstElements.get(i).getIdElement() + '"' + ":" + '"' + lstElements.get(i).getValorElement() + '"');
            if (i < (lstElements.size() - 1)) {
                strBuilder.append(",");
            }
        }
        strBuilder.append("}");

        return strBuilder.toString();
    }
}
