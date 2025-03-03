package com.yakush.task_management.services;

import com.yakush.task_management.models.User;

import java.util.List;


public interface UserService {
    List<User> findAllUsers();
    User findByEmail(String email);
    User findById(Long id);
    User findByEmailAndPassword(String email, String password);
    void saveUser(User user);

    User updateUserNameByEmail(String email, String name);
    User updateUserEmailByEmail(String email, String newEmail);
    User updateUserPasswordByEmail(String email, String password);
}
