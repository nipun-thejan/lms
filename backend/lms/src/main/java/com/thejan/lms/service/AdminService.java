package com.thejan.lms.service;

import com.thejan.lms.dto.RegisterRequest;
import com.thejan.lms.entity.User;

import java.util.List;

public interface AdminService {
    List<User> getAllUsers();

    Object assignNewAdmin(RegisterRequest registerRequest) throws Exception;
}
