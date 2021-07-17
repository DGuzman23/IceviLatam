package com.uca.service;

import com.uca.model.Role;
import com.uca.model.User;
import com.uca.repository.RoleRepository;
import com.uca.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder encoder;

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public void save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        user.setStatus("VERIFIED");
        Role role = roleRepository.getByName("ADMIN");
        user.setRoles(new HashSet<Role>(Arrays.asList(role)));
        userRepository.save(user);
    }

    @Override
    public Boolean isUserAlreadyPresent(User user) {
        boolean userExist = false;
        User existingUser = userRepository.getUserByUsername(user.getUsername());
        if (existingUser != null) {
            userExist = true;
        }
        return userExist;
    }
}