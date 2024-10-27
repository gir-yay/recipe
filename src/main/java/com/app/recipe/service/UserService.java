package com.app.recipe.service;

import com.app.recipe.model.User;

public interface UserService {

    public User findUserById(Long id) throws Exception;

}
