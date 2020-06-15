package com.example.demo.model;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
public class AkunRequest {
    String nama;

    String kelas;

    String nim;

    String prodi;

    String gd;

    public AkunRequest(String nama, String kelas, String nim, String prodi, String gd) {
        this.nama = nama;
        this.kelas = kelas;
        this.nim = nim;
        this.prodi = prodi;
        this.gd = gd;
    }

    public String getGd() {
        return gd;
    }

    public void setGd(String gd) {
        this.gd = gd;
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

}
