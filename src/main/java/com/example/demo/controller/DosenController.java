package com.example.demo.controller;

import com.example.demo.model.AkunDosen;
import com.example.demo.model.AkunDosenRequest;
import com.example.demo.model.AkunResponse;
import com.example.demo.model.LoginRequest;
import com.example.demo.repository.AkunDosenRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 15/06/2020.
 */
@Controller
@CrossOrigin
@RequestMapping("/dosen")
public class DosenController {

    @Autowired
    AkunDosenRepo akunDosenRepo;

    @GetMapping("/")
    public ResponseEntity<?> findAll(){
        return ResponseEntity.ok().body(akunDosenRepo.findAll());
    }
    @PostMapping("/add")
    public ResponseEntity<?> daftar(@RequestBody AkunDosenRequest akunDosenRequest){
        AkunDosen akunDosen= new AkunDosen(
                UUID.randomUUID().toString(),
                akunDosenRequest.getNama(),
                akunDosenRequest.getNik(),
                akunDosenRequest.getUsername(),
                akunDosenRequest.getPassword()
        );
        akunDosenRepo.save(akunDosen);
        return ResponseEntity.ok("Sukses");
    }

    @PostMapping("/login")
    public ResponseEntity<?>login(@RequestBody LoginRequest loginRequest){
        if(akunDosenRepo.existsByUsername(loginRequest.getUsername())){
            AkunDosen akunDosen = akunDosenRepo.findFirstByUsername(loginRequest.getUsername());
            if(loginRequest.getPassword().equals(akunDosen.getPassword())){
                return ResponseEntity.ok().body(new AkunResponse("Sukses"));
            }
            return ResponseEntity.ok().body(new AkunResponse("Password Is Wrong"));
        }
        return ResponseEntity.ok().body(new AkunResponse("Username Not Found"));
    }
}
