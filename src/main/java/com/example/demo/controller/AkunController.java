package com.example.demo.controller;

import com.example.demo.model.AkunRequest;
import com.example.demo.model.AkunResponse;
import com.example.demo.repository.AkunRepo;
import com.example.demo.service.AkunServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@Controller
@RequestMapping("/barcodeApp")
public class AkunController {


    @Autowired
    AkunServiceImpl akunService;

    @Autowired
    AkunRepo akunRepo;

    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(akunRepo.findAll());
    }

    @PostMapping("/add")
    public ResponseEntity<?> tambahData(@RequestBody AkunRequest akunRequest) {
        akunService.addAkun(akunRequest);
        return ResponseEntity.ok().body(new AkunResponse("Berhasil"));
    }

    @GetMapping("/check/{nim}")
    public ResponseEntity<?> masuk(@PathVariable String nim) {
        if(akunService.check(nim)==0){
            akunService.masuk(nim);

            return ResponseEntity.ok().body(new AkunResponse("Berhasil Masuk"));
        }else{
            akunService.keluar(nim);

            return ResponseEntity.ok().body(new AkunResponse("Berhasil Keluar"));
        }
    }

    @GetMapping("/test/{nim}")
    public ResponseEntity<?> test(@PathVariable String nim) {
        return ResponseEntity.ok().body(new AkunResponse(akunService.check(nim).toString()));
    }

}
