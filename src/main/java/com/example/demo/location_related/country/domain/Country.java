package com.example.demo.location_related.country.domain;

import com.example.demo.common.domain.BaseLongDomain;

public class Country  extends BaseLongDomain{
    private final String code;
    private final String name;

    public Country(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}

