package com.example.todolist.todo.controller;

import com.example.todolist.todo.dto.TodoReqDto;
import com.example.todolist.todo.dto.TodoResDto;
import com.example.todolist.todo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/api/todo")
@RestController
public class TodoController {

    private final TodoService todoService;

    @PostMapping("/save")
    public ResponseEntity<?> todoList(TodoReqDto req) {
        return new ResponseEntity<>(todoService.save(req), HttpStatus.CREATED);
    }

}
