package com.ericleedev.server.service;

import com.ericleedev.server.dao.ToDoListRepository;
import com.ericleedev.server.entity.TodoList;
import com.ericleedev.server.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TodoListServices implements ITodoListServices{
    private ToDoListRepository todoListRepository;

    @Autowired
    public TodoListServices(ToDoListRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @Override
    public List<TodoList> findListByUserId(int userId) {
        return todoListRepository.findByUserId(userId);
    }

    @Override
    public List<TodoList> findAll() {
        return todoListRepository.findAll();
    }

    @Override
    public TodoList findById(int theId) {

        Optional<TodoList> query = todoListRepository.findById(theId);
        TodoList list = null;

        if(query == null){
            throw new NotFoundException("TodoList Not found ! Id - " + theId);
        }
        else {
            list = query.get();
        }

        return list;
    }

    @Override
    public void deleteById(int theId) {
        todoListRepository.deleteById(theId);
    }

    @Override
    public void save(TodoList obj) {
        todoListRepository.save(obj);
    }
}
