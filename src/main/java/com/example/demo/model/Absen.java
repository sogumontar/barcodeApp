package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/06/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = "absen")
public class Absen {
    @Id
    String id;

    @Column(name = "nama")
    String nama;

    @Column(name = "nim")
    String nim;

    @Column(name = "kode")
    String kode;

    @Column(name = "prodi")
    String prodi;

    @Column(name = "gd")
    String gd;

    @Column(name = "kelas")
    String kelas;

    @Column(name = "date")
    String date;

    public Absen(String id, String nama, String nim, String kode, String prodi, String gd, String kelas, String date) {
        this.id = id;
        this.nama = nama;
        this.nim = nim;
        this.kode = kode;
        this.prodi = prodi;
        this.gd = gd;
        this.kelas = kelas;
        this.date = date;
    }

    public String getProdi() {
        return prodi;
    }

    public void setProdi(String prodi) {
        this.prodi = prodi;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
    }

    public String getKelas() {
        return kelas;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
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

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }
}
