package com.proassistant.ProAssistant.services;

import com.proassistant.ProAssistant.entities.Users;
import com.proassistant.ProAssistant.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Users registerUser(Users users) {
        return userRepository.save(users);
    }

    @Override
    public Users loginUser(String username, String password) {
        Users users = userRepository.findByUsername(username);

        if (users != null && users.getPassword().equals(password)) {
            return users;
        }

        return null;
    }
}
