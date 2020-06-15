package com.example.demo.service;

import com.example.demo.model.TimeOut;
import com.example.demo.repository.TimeOutRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by Sogumontar Hendra Simangunsong on 14/06/2020.
 */
@Service
public class TimeOutService {

    @Autowired
    TimeOutRepo timeOutRepo;

    public Boolean checkIfExpired(String kode){
        int i = (int) (new Date().getTime()/1000);
        TimeOut timeOut = timeOutRepo.findFirstByKode(kode);
        if(i-timeOut.getDate()>=1800){
            return false;
        }
        return true;
    }

}
