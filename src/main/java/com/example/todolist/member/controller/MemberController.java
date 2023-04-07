package com.example.todolist.member.controller;

import com.example.todolist.member.service.MemberService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestParam String name) {
        try {
            return new ResponseEntity<>(memberService.save(name), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getMember(@PathVariable Long id) {
        return new ResponseEntity<>(memberService.getMember(id), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllMember() {
        return new ResponseEntity<>(memberService.getAllMember(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
