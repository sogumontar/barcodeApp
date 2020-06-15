package com.example.demo.service;

import com.example.demo.model.Akun;
import com.example.demo.model.AkunRequest;
import com.example.demo.repository.AkunRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@Service
public class AkunServiceImpl {

    @Autowired
    AkunRepo akunRepo;
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();

    public void addAkun(AkunRequest akunRequest) {

        Akun akun = new Akun(
                UUID.randomUUID().toString(),
                akunRequest.getNama(),
                akunRequest.getKelas(),
                akunRequest.getNim(),
                akunRequest.getProdi(),
                akunRequest.getGd(),
                0,
                dtf.format(now).toString()
        );
        akunRepo.save(akun);
    }

    public void keluar(String nim) {
        akunRepo.keluar(nim,dtf.format(now));
    }

    public void masuk(String nim) {
        akunRepo.masuk(nim,dtf.format(now));
    }

    public Integer check(String nim) {
        Akun akun = akunRepo.findFirstByNim(nim);
        return akun.getLog();

    }
}
