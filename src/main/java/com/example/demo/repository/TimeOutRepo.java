package com.example.demo.repository;

import com.example.demo.model.TimeOut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/06/2020.
 */
@Repository
public interface TimeOutRepo extends JpaRepository<TimeOut,String> {
    TimeOut findFirstByKode(String kode);
}
