package io.dz.memberservice.controller;

import io.dz.memberservice.model.Member;
import io.dz.memberservice.service.MemberService;
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
@RequestMapping("member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("status")
    public ResponseEntity status(){
        return new ResponseEntity("Member-service up",HttpStatus.OK);
    }
    @GetMapping("/getAll")
    public ResponseEntity findAll(){
        return new ResponseEntity(memberService.getAll(),HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity saveMember(@RequestBody Member member){
        return new ResponseEntity(memberService.save(member),HttpStatus.OK);
    }

    @GetMapping("/getById/{memberId}")
    public ResponseEntity getById(@PathVariable String memberId){
        return new ResponseEntity(memberService.findById(memberId),HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity update(@RequestBody Member member){
        return new ResponseEntity(memberService.update(member),HttpStatus.OK);
    }
}
