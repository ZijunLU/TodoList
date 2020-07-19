package com.ericleedev.server.rest;

import com.ericleedev.server.entity.TodoList;
import com.ericleedev.server.service.TodoListServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todolists")
public class TodoListController {
    private TodoListServices todoListServices;

    @Autowired
    public TodoListController(TodoListServices todoListServices) {
        this.todoListServices = todoListServices;
    }

    @GetMapping("/")
    public List<TodoList> getAllTodoList(){
        return todoListServices.findAll();
    }

    @GetMapping("/me")
    public List<TodoList> getTodoListByUserId(@RequestParam(name="id") int userId){
        return todoListServices.findListByUserId(userId);
    }

    @GetMapping("/{id}")
    public TodoList getTodoListById(@PathVariable int id){
        return todoListServices.findById(id);
    }

    @PostMapping("/")
    public TodoList createTodoList(@RequestBody TodoList todoList){
        todoList.getTodoItems().forEach((todoItem -> todoItem.setTodoList(todoList)));
        todoListServices.save(todoList);
        return todoList;
    }


}
