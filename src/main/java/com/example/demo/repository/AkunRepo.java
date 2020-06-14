package com.example.demo.repository;

import com.example.demo.model.Akun;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@Repository
public interface AkunRepo extends JpaRepository<Akun,String> {

    @Transactional
    @Modifying
    @Query("UPDATE Akun p  SET p.log=0, p.date=?2 WHERE p.nim LIKE ?1")
    void keluar(String nim, String date);

    @Transactional
    @Modifying
    @Query("UPDATE Akun p  SET p.log=1, p.date=?2 WHERE p.nim LIKE ?1")
    void masuk(String nim, String date);

    Akun findFirstByNim(String nim);

    Boolean existsByNim(String nim);

}
