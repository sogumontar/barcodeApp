package com.example.demo.model;

import lombok.NoArgsConstructor;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/06/2020.
 */
@NoArgsConstructor
public class AkunDosenRequest {

    String nama;

    String nik;

    String username;

    String password;

    public AkunDosenRequest(String nama, String nik, String username, String password) {
        this.nama = nama;
        this.nik = nik;
        this.username = username;
        this.password = password;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
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
