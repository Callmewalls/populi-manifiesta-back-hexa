package com.example.demo.location_related.city.infrastructure.out.persistence;

import java.math.BigDecimal;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="city")
public class CityEntity extends BaseLongEntity{
    
    @Column(name="name")
    private String name;
    
    @Column(name="stateId")
    private Long stateId;  
    
    @Column(name="countryId")
    private Long countryId;
    
    @Column(name="latitude")
    private BigDecimal latitude;
    
    @Column(name="longitude")
    private BigDecimal longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStateId() {
        return stateId;
    }

    public void setStateId(Long stateId) {
        this.stateId = stateId;
    }

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }
    
}
