package com.example.demo.location_related.state.domain;

import com.example.demo.common.domain.BaseLongDomain;

public class State  extends BaseLongDomain{

    private final String code; // ISO3166-2 o generado
    private final String name;
    private final Long countryId; // relación con Country

    public State(String code, String name, Long countryId) {
        this.code = code;
        this.name = name;
        this.countryId = countryId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public Long getCountryId() {
        return countryId;
    }
}
