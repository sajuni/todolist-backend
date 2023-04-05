package com.example.todolist.todo.service;

import com.example.todolist.member.entity.Member;
import com.example.todolist.member.repository.MemberRepository;
import com.example.todolist.todo.dto.TodoReqDto;
import com.example.todolist.todo.dto.TodoResDto;
import com.example.todolist.todo.entity.Todo;
import com.example.todolist.todo.repository.TodoRepository;
import com.example.todolist.todo.util.TodoStatus;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final MemberRepository memberRepository;

    private final ModelMapper modelMapper;

    public TodoResDto save(TodoReqDto req) {
        Optional<Member> findMember = memberRepository.findById(req.getMemberId());
        if (findMember.isPresent()) {
            Member member = findMember.get();
            Todo todo = Todo.builder().content(req.getContent()).member(member).build();
            Todo resultTodoEntity = todoRepository.save(todo);
            return modelMapper.map(resultTodoEntity, TodoResDto.class);
        }
        throw new RuntimeException("Todo 저장에 실패 했습니다.");
    }

    public TodoResDto update(Long id, String status) {
        Optional<Todo> findTodo = todoRepository.findById(id);
        if (findTodo.isPresent()) {
            Todo todo = findTodo.get();
            todo.setStatus(TodoStatus.valueOf(status));
            Todo resultTodoEntity = todoRepository.save(todo);
            return modelMapper.map(resultTodoEntity, TodoResDto.class);
        }
        throw new RuntimeException("Todo 저장에 실패 했습니다.");
    }

}
