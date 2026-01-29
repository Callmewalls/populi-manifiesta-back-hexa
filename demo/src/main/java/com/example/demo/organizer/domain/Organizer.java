package com.example.demo.organizer.domain;

import com.example.demo.common.domain.BaseLongDomain;

public class Organizer extends BaseLongDomain {
    private String nif;
    private String name;
    private String last_names;
    private String email;
    private Integer phone;
    private Long location_id;
    private String resp_name;
    private String resp_nif;
    private Integer resp_phone;

    public Organizer(String nif, String name, String last_names, String email, Integer phone, Long location_id,
            String resp_name, String resp_nif, Integer resp_phone) {
        this.nif = nif;
        this.name = name;
        this.last_names = last_names;
        this.email = email;
        this.phone = phone;
        this.location_id = location_id;
        this.resp_name = resp_name;
        this.resp_nif = resp_nif;
        this.resp_phone = resp_phone;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nif == null) ? 0 : nif.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((last_names == null) ? 0 : last_names.hashCode());
        result = prime * result + ((email == null) ? 0 : email.hashCode());
        result = prime * result + ((phone == null) ? 0 : phone.hashCode());
        result = prime * result + ((location_id == null) ? 0 : location_id.hashCode());
        result = prime * result + ((resp_name == null) ? 0 : resp_name.hashCode());
        result = prime * result + ((resp_nif == null) ? 0 : resp_nif.hashCode());
        result = prime * result + ((resp_phone == null) ? 0 : resp_phone.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Organizer other = (Organizer) obj;
        if (nif == null) {
            if (other.nif != null)
                return false;
        } else if (!nif.equals(other.nif))
            return false;
        if (name == null) {
            if (other.name != null)
                return false;
        } else if (!name.equals(other.name))
            return false;
        if (last_names == null) {
            if (other.last_names != null)
                return false;
        } else if (!last_names.equals(other.last_names))
            return false;
        if (email == null) {
            if (other.email != null)
                return false;
        } else if (!email.equals(other.email))
            return false;
        if (phone == null) {
            if (other.phone != null)
                return false;
        } else if (!phone.equals(other.phone))
            return false;
        if (location_id == null) {
            if (other.location_id != null)
                return false;
        } else if (!location_id.equals(other.location_id))
            return false;
        if (resp_name == null) {
            if (other.resp_name != null)
                return false;
        } else if (!resp_name.equals(other.resp_name))
            return false;
        if (resp_nif == null) {
            if (other.resp_nif != null)
                return false;
        } else if (!resp_nif.equals(other.resp_nif))
            return false;
        if (resp_phone == null) {
            if (other.resp_phone != null)
                return false;
        } else if (!resp_phone.equals(other.resp_phone))
            return false;
        return true;
    }

}
