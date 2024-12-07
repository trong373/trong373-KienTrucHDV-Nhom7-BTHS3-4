package com.example.bths2.entity;


import jakarta.persistence.*;

@Entity 
@Table(name = "User")
public class User {

    @Id // Khóa chính
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(nullable = false, unique = true) 
    private String userName;

    @Column(nullable = false) 
    private String password;

    @Column 
    private String token;

    // Getters và Setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
