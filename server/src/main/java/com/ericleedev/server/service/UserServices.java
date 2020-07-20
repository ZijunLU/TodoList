package com.ericleedev.server.service;

import com.ericleedev.server.dao.UserRepository;
import com.ericleedev.server.entity.User;
import com.ericleedev.server.error.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServices implements IService<User>{

    private UserRepository userRepository;

    @Autowired
    public UserServices(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(int theId) {
        Optional<User> query = userRepository.findById(theId);
        User user = null;
        if(query == null){
            throw new NotFoundException("User not found! Id - " + theId);
        }
        else {
            user = query.get();
        }
        return user;
    }

    @Override
    public void deleteById(int theId) {
        userRepository.deleteById(theId);
    }

    @Override
    public void save(User obj) {
        userRepository.save(obj);
    }
}
