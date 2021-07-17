package com.uca.service;

import com.uca.model.User;

public interface UserService {

    void save(User usuario);

    Boolean isUserAlreadyPresent(User usuario);
}