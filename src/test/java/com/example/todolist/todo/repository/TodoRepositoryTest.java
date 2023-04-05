package com.example.todolist.todo.repository;

import com.example.todolist.member.entity.Member;
import com.example.todolist.member.repository.MemberRepository;
import com.example.todolist.todo.entity.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberSaveTest() {
        memberRepository.save(Member.builder().name("강백호").build());
    }

    @Test
    void todoSaveTest() {
        Member member = memberRepository.findByName("강백호");
        Todo todo = Todo.builder().content("테스트2").member(member).build();
        todoRepository.save(todo);
    }

}