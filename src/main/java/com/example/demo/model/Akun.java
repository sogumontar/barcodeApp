package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = "akun")
public class Akun {
    @Id
    String id;

    @Column(name = "nama")
    String nama;

    @Column(name = "kelas")
    String kelas;

    @Column(name = "nim")
    String nim;

    @Column(name = "prodi")
    String prodi;

    @Column(name = "log")
    Integer log;

    @Column(name = "date")
    String date;

    public Akun(String id, String nama, String kelas, String nim, String prodi, Integer log, String date) {
        this.id = id;
        this.nama = nama;
        this.kelas = kelas;
        this.nim = nim;
        this.prodi = prodi;
        this.log = log;
        this.date = date;
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

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public Integer getLog() {
        return log;
    }

    public void setLog(Integer log) {
        this.log = log;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
