package com.example.todolist.member.dto;

import com.example.todolist.todo.dto.TodoResDto;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class MemberDto {
    private Long id;
    private String name;
    private List<TodoResDto> todoList = new ArrayList<>();
}
