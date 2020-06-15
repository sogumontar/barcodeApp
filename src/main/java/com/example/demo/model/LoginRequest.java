package com.example.demo.model;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/06/2020.
 */
@NoArgsConstructor
public class LoginRequest {
    String username;
    String password;

    public LoginRequest(String username, String password) {
        this.username = username;
        this.password = password;
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
