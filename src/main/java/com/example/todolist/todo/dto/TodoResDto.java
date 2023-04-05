package com.example.todolist.todo.dto;

import com.example.todolist.todo.util.TodoStatus;
import lombok.Data;

@Data
public class TodoResDto {
    private Long id;
    private String content;
    private TodoStatus status;
    private Long memberId;
}
