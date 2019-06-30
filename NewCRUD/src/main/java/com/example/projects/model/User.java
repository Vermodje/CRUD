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
    @Column(name = "login")
    @NotNull
    private String login;
    public User() {

    }

    public User(Long id, String name, String password, String login) {
        this(name, password, login);
        this.setId(id);
    }

    public User(String name, String password, String login) {
        this.setName(name);
        this.setPassword(password);
        this.setLogin(login);
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

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
