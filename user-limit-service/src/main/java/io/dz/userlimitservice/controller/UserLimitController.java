package io.dz.userlimitservice.controller;

import io.dz.userlimitservice.model.UserLimit;
import io.dz.userlimitservice.service.UserLimitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userLimit")
public class UserLimitController {
    @Autowired
    private UserLimitService userLimitService;

    @GetMapping("/status")
    public ResponseEntity status(){
        return new ResponseEntity("User-Limit-Service",HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity save(@RequestBody UserLimit userLimit){
       return new ResponseEntity(userLimitService.save(userLimit),HttpStatus.OK);
    }

    @GetMapping("/getById/{memberId}")
    public ResponseEntity getById(@PathVariable String memberId){
        return new ResponseEntity(userLimitService.getById(memberId),HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity update(@RequestBody UserLimit userLimit){
        return new ResponseEntity(userLimitService.update(userLimit),HttpStatus.OK);
    }
}
