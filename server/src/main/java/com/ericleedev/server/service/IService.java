package com.ericleedev.server.service;

import java.util.List;

public interface IService<T> {
    public List<T> findAll();
    public T findById(int theId);
    public void deleteById(int theId);
    public void save(T obj);

}
