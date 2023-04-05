package com.example.todolist.todo.controller;

import com.example.todolist.todo.dto.TodoReqDto;
import com.example.todolist.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api/todo")
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/save")
    public ResponseEntity<?> todoList(TodoReqDto req) {
        return new ResponseEntity<>(todoService.save(req), HttpStatus.CREATED);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateStatus(@PathVariable Long id, @RequestParam String status) {
        return new ResponseEntity<>(todoService.update(id, status), HttpStatus.OK);
    }
}
