package com.example.demo.location_related.country.infrastructure.out.persistence;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="country")
public class CountryEntity extends BaseLongEntity{
    
    @Column(name="code")
    private String code;
    @Column(name="name")
    private String name;

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
