package com.example.demo.organizer.infrastructure.out.persistence;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="organizer")
public class OrganizerEntity extends BaseLongEntity{ 
    
    @Column(name="nif")
    private String nif;
    @Column(name="name")
    private String name;
    @Column(name="last_names")
    private String last_names;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private Integer phone;
    @Column(name="location_id")
    private Long location_id;
    @Column(name="resp_name")
    private String resp_name;
    @Column(name="resp_nif")
    private String resp_nif;
    @Column(name="resp_phone")
    private Integer resp_phone;

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
    public String getLast_names() {
        return last_names;
    }
    public void setLast_names(String last_names) {
        this.last_names = last_names;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Integer getPhone() {
        return phone;
    }
    public void setPhone(Integer phone) {
        this.phone = phone;
    }
    public Long getLocation_id() {
        return location_id;
    }
    public void setLocation_id(Long location_id) {
        this.location_id = location_id;
    }
    public String getResp_name() {
        return resp_name;
    }
    public void setResp_name(String resp_name) {
        this.resp_name = resp_name;
    }
    public String getResp_nif() {
        return resp_nif;
    }
    public void setResp_nif(String resp_nif) {
        this.resp_nif = resp_nif;
    }
    public Integer getResp_phone() {
        return resp_phone;
    }
    public void setResp_phone(Integer resp_phone) {
        this.resp_phone = resp_phone;
    }

}