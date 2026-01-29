package com.example.demo.location_related.location.infrastructure.out.persistence;

import java.math.BigDecimal;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="location")
public class LocationEntity extends BaseLongEntity{
    
    @Column(name="latitude")
    private BigDecimal latitude;

    @Column(name="longitude")
    private BigDecimal longitude;

    @Column(name="cityId")
    private Long cityId;

    @Column(name="address_label")
    private String addressLabel;

    @Column(name="name")
    private String name;

    public String getAddressLabel() {
        return addressLabel;
    }
    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
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
    public Long getCityId() {
        return cityId;
    }
    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    
}
