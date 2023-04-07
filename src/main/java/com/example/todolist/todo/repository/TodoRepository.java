package com.example.todolist.todo.repository;

import com.example.todolist.todo.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {

    @Modifying
    @Query("DELETE FROM Todo t WHERE t.member.id = :memberId")
    void deleteTodoListByMemberId(@Param("memberId") Long memberId);
}
