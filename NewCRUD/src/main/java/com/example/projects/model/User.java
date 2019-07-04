package com.example.projects.model;


import org.jetbrains.annotations.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @NotNull
    private String name;
    @Column(name = "password")
    @NotNull
    private String password;
    @Column(name = "login", unique = true)
    @NotNull
    private String login;
    @Column(name = "role")
    @NotNull
    private String role;

    public User() {

    }

    public User(Long id, String name, String password, String login, String role) {
        this(name, password, login, role);
        this.setId(id);
    }

    public User(String name, String password, String login, String role) {
        this.setName(name);
        this.setPassword(password);
        this.setLogin(login);
        this.setRole(role);
    }

    public Long getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public String getRole() {
        return role;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
