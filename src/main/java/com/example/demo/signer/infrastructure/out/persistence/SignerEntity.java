package com.example.demo.signer.infrastructure.out.persistence;

import java.time.LocalDate;

import com.example.demo.common.infrastructure.BaseLongEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "signer")
public class SignerEntity extends BaseLongEntity {

    @Column(name = "nif", unique = true, nullable = false)
    private String nif;

    @Column(name = "name", unique = false, nullable = false)
    private String name;

    @Column(name = "last_names", unique = false, nullable = true)
    private String lastNames;

    @Column(name = "birth_date", unique = false, nullable = true)
    private LocalDate birthDate;

    @Column(name = "user_id", unique = false, nullable = false)
    private Long userId;

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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((nif == null) ? 0 : nif.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        result = prime * result + ((lastNames == null) ? 0 : lastNames.hashCode());
        result = prime * result + ((birthDate == null) ? 0 : birthDate.hashCode());
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
        SignerEntity other = (SignerEntity) obj;
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
        if (lastNames == null) {
            if (other.lastNames != null)
                return false;
        } else if (!lastNames.equals(other.lastNames))
            return false;
        if (birthDate == null) {
            if (other.birthDate != null)
                return false;
        } else if (!birthDate.equals(other.birthDate))
            return false;
        return true;
    }

}
