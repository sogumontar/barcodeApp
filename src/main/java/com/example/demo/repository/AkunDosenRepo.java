package com.example.demo.repository;

import com.example.demo.model.AkunDosen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/06/2020.
 */
@Repository
public interface AkunDosenRepo extends JpaRepository<AkunDosen,String> {
    AkunDosen findFirstByUsername(String usename);
    Boolean existsByUsername(String username);
}
