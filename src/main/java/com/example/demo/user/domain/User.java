package com.example.demo.user.domain;

import com.example.demo.role.domain.Role;

public class User {

    private final Long id;
    private final String email;
    private final String password;
    private final Role role;

    public User(Long id, String email, String password, Role role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() { return id; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Role getRole() {return role;}
}
