package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/06/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = "akun_dosen")
public class AkunDosen {
    @Id
    String id;

    @Column(name = "nama")
    String nama;

    @Column(name = "nik")
    String nik;

    @Column(name = "username")
    String username;

    @Column(name = "password")
    String password;

    public AkunDosen(String id, String nama, String nik, String username, String password) {
        this.id = id;
        this.nama = nama;
        this.nik = nik;
        this.username = username;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
