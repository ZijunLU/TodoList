package com.ericleedev.server.service;

import com.ericleedev.server.entity.TodoList;

import java.util.List;

public interface ITodoListServices extends IService<TodoList>{
    List<TodoList> findListByUserId(int userId);
}
