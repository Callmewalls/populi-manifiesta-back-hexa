package com.example.demo.location_related.location.domain;

import java.math.BigDecimal;

import com.example.demo.common.domain.BaseLongDomain;

public class Location extends BaseLongDomain {

    private BigDecimal latitude;

    private BigDecimal longitude;

    private Long cityId;

    private String addressLabel;

    private String name;

    public Location(String addressLabel, BigDecimal latitude, BigDecimal longitude,
            Long cityId,String name) {
        this.addressLabel = addressLabel;
        this.latitude = latitude;
        this.name = name;
        this.longitude = longitude;
        this.cityId = cityId;
    }

    

    public String getAddressLabel() {
        return addressLabel;
    }
    
    public void setAddressLabel(String addressLabel) {
        this.addressLabel = addressLabel;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public Long getCityId() {
        return cityId;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
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