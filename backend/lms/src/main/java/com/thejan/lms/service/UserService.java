package com.thejan.lms.service;


import com.thejan.lms.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username);
    User saveUser(User user);

//    Object getProfile(String email);
//    Object getProfile(Long id);

}