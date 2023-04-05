package com.example.todolist.todo.entity;

import com.example.todolist.member.entity.Member;
import com.example.todolist.todo.util.TodoStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "todo_id")
    private Long id;

    private String content;

    @Enumerated(EnumType.STRING)
    @Builder.Default
    private TodoStatus status = TodoStatus.CREATE;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;


}
