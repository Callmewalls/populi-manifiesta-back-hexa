package com.example.demo.user.infrastructure.out.persistence;

import com.example.demo.common.infrastructure.BaseLongEntity;
import com.example.demo.role.infrastructure.out.persistence.RoleEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends BaseLongEntity {

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="password", nullable = false)
    private String password;

    @ManyToOne(fetch = FetchType.LAZY) // muchos usuarios pueden tener un mismo rol
    @JoinColumn(name = "role_id", nullable = false) // esta columna es la FK
    private RoleEntity role;

    // Getters y setters
    public RoleEntity getRole() {
        return role;
    }

    public void setRole(RoleEntity role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}