package com.example.demo.signer.domain;

import java.util.Date;

import com.example.demo.common.domain.BaseLongDomain;

public class Signer extends BaseLongDomain{
 
    private String nif;
    
    private String name;
    
    private String lastNames;
    
    private Date birthDate;
    
    private Long userId;

    public Signer(String nif, String name, String lastNames, Date birthDate, Long userId) {
        this.nif = nif;
        this.name = name;
        this.lastNames = lastNames;
        this.birthDate = birthDate;
        this.userId = userId;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastNames() {
        return lastNames;
    }

    public void setLastNames(String lastNames) {
        this.lastNames = lastNames;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

}
