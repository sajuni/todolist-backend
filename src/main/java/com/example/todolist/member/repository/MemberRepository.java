package com.example.todolist.member.repository;

import com.example.todolist.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByName(String name);

    @Query("SELECT DISTINCT m FROM Member m LEFT JOIN FETCH m.todoList ORDER BY m.id")
    List<Member> findAllTodoList();
}
