package com.example.demo.repository;

import com.example.demo.model.Absen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/06/2020.
 */
@Repository
public interface AbsenRepo extends JpaRepository<Absen,String> {
    List<Absen> findAllByKode(String kode);
}

