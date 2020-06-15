package com.example.demo.controller;

        import com.example.demo.model.*;
        import com.example.demo.repository.AbsenRepo;
        import com.example.demo.repository.AkunRepo;
        import com.example.demo.repository.TimeOutRepo;
        import com.example.demo.service.AkunServiceImpl;
        import com.example.demo.service.TimeOutService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.http.ResponseEntity;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.*;

        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        import java.util.Date;
        import java.util.UUID;

/**
 * Created by Sogumontar Hendra Simangunsong on 13/06/2020.
 */
@CrossOrigin
@Controller
@RequestMapping("/barcodeApp")
public class AkunController {


    @Autowired
    AkunServiceImpl akunService;

    @Autowired
    AkunRepo akunRepo;

    @Autowired
    TimeOutRepo timeOutRepo;

    @Autowired
    TimeOutService timeOutService;

    @Autowired
    AbsenRepo absenRepo;

    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
    LocalDateTime now = LocalDateTime.now();
    int i = (int) (new Date().getTime()/1000);
    @GetMapping("/")
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(akunRepo.findAll());
    }


    @GetMapping("/checkNim/{nim}")
    public ResponseEntity<?> checkNim(@PathVariable String nim) {
        if (akunRepo.existsByNim(nim)) {
            return ResponseEntity.ok().body(new AkunResponse("Ada"));
        }
        return ResponseEntity.ok().body(new AkunResponse("Tidak Ada"));
    }

    @PostMapping("/add")
    public ResponseEntity<?> tambahData(@RequestBody AkunRequest akunRequest) {
        akunService.addAkun(akunRequest);
        return ResponseEntity.ok().body(new AkunResponse("Berhasil"));
    }

    @GetMapping("/check/{nim}")
    public ResponseEntity<?> masuk(@PathVariable String nim) {
        if (akunService.check(nim) == 0) {
            akunService.masuk(nim);

            return ResponseEntity.ok().body(new AkunResponse("Berhasil Masuk"));
        } else {
            akunService.keluar(nim);

            return ResponseEntity.ok().body(new AkunResponse("Berhasil Keluar"));
        }
    }

    @GetMapping("/test/{nim}")
    public ResponseEntity<?> test(@PathVariable String nim) {
        return ResponseEntity.ok().body(new AkunResponse(akunService.check(nim).toString()));
    }


    @GetMapping("/absen/all/{kode}")
    public ResponseEntity<?> findAllAbsen( @PathVariable String kode) {

        return ResponseEntity.ok(absenRepo.findAllByKode(kode));
    }


    @GetMapping("/absen/{nim}/{kode}")
    public ResponseEntity<?> absen(@PathVariable String nim, @PathVariable String kode) {
        if(timeOutService.checkIfExpired(kode)){
            Akun akun = akunRepo.findFirstByNim(nim);
            Absen absen = new Absen(
                    UUID.randomUUID().toString(),
                    akun.getNama(),
                    nim,
                    kode,
                    akun.getProdi(),
                    akun.getGd(),
                    akun.getKelas(),
                    dtf.format(now).toString()
            );
            absenRepo.save(absen);
            return ResponseEntity.ok().body(new AkunResponse("Sukses"));
        }
        return ResponseEntity.ok().body(new AkunResponse("Exp"));
    }

    @GetMapping("/timeOut/all")
    public ResponseEntity<?> findAllTimeOut(){
        return ResponseEntity.ok(timeOutRepo.findAll());
    }
    @PostMapping("/set/{kode}")
    public ResponseEntity<?> setTimeOut(@PathVariable String kode) {
        TimeOut timeOut = new TimeOut(
                UUID.randomUUID().toString(),
                kode,
                i,
                "Active");
        timeOutRepo.save(timeOut);
        return ResponseEntity.ok().body(new AkunResponse("Sukses"));
    }

}
