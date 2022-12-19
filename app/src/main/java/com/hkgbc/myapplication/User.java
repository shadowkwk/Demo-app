package com.hkgbc.myapplication;

public class User {
    private int id;
    private String username, email, qr;

    public User(int id, String username, String email, String qr) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.qr = qr;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getQr() {
        return qr;
    }
}
