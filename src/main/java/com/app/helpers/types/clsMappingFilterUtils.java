/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.helpers.types;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import org.springframework.http.converter.json.MappingJacksonValue;

public class clsMappingFilterUtils {

    public enum JsonFilterMode {
        INCLUDE_FIELD_MODE, EXCLUDE_FIELD_MODE
    }

    public static MappingJacksonValue applyFilter(Object object, final JsonFilterMode mode, final String filterName, final String... fields) {
        if (fields == null || fields.length == 0) {
            throw new IllegalArgumentException("You should pass at least one field");
        }
        return applyFilter(object, mode, filterName, new HashSet<>(Arrays.asList(fields)));
    }

    public static MappingJacksonValue applyFilter(Object object, final JsonFilterMode mode, final String filterName, final Set<String> fields) {
        if (fields == null || fields.isEmpty()) {
            throw new IllegalArgumentException("You should pass at least one field");
        }

        SimpleBeanPropertyFilter filter = null;
        switch (mode) {
            case EXCLUDE_FIELD_MODE:
                filter = SimpleBeanPropertyFilter.serializeAllExcept(fields);
                break;
            case INCLUDE_FIELD_MODE:
                filter = SimpleBeanPropertyFilter.filterOutAllExcept(fields);
                break;
        }

        FilterProvider filters = new SimpleFilterProvider().addFilter(filterName, filter);
        MappingJacksonValue mapping = new MappingJacksonValue(object);
        mapping.setFilters(filters);
        return mapping;
    }
}
