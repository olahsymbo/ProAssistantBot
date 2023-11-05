package com.proassistant.ProAssistant.services;

import com.proassistant.ProAssistant.entities.Users;

public interface UserService {
    Users registerUser(Users user);
    Users loginUser(String username, String password);
}
