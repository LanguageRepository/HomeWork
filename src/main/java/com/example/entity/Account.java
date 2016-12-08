package com.example.entity;

import javax.persistence.*;

@Entity
@Table(name = "account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username") //For adjustments in the future
    private String username;

    @Column(name = "password") //For adjustments in the future
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Account() { //for jpa
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { //for method Update
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
