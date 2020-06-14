package com.example.demo.model;

import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/06/2020.
 */
@Entity
@NoArgsConstructor
@Table(name = "timeout")
public class TimeOut {
    @Id
    String id;

    @Column(name = "kode")
    String kode;

    @Column(name = "date")
    Integer date;

    @Column(name = "status")
    String status;

    public TimeOut(String id, String kode, Integer date, String status) {
        this.id = id;
        this.kode = kode;
        this.date = date;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public Integer getDate() {
        return date;
    }

    public void setDate(Integer date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
