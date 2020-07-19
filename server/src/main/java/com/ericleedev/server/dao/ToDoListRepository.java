package com.ericleedev.server.dao;

import com.ericleedev.server.entity.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoListRepository extends JpaRepository<TodoList, Integer> {
    @Query("from TodoList where user_id=?1")
    List<TodoList> findByUserId(int userId);
}
