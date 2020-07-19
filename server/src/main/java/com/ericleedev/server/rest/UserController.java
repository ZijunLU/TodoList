package com.ericleedev.server.rest;

import com.ericleedev.server.entity.User;
import com.ericleedev.server.service.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserServices userServices;

    @Autowired
    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }

    @GetMapping("/")
    public List<User> getUsers(){
        return userServices.findAll();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable int id){
        return userServices.findById(id);
    }

    @PostMapping("/")
    public User createUser(@RequestBody User user){
        user.setCreatedAt(new Date().toString());
        user.setUpdatedAt(new Date().toString());
        userServices.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id){
        User target = userServices.findById(id);

        // throw exception if null
        if(target == null){
            throw new RuntimeException("Employee id not found - " + id);
        }
        userServices.deleteById(id);

        return "Deleted employee id - " + id;
    }


}
