package com.app.recipe.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.recipe.config.JwtProvider;
import com.app.recipe.model.User;
import com.app.recipe.repository.UserRepository;

@Service
public class UserServiceImp implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtProvider jwtProvider;

    @Override
    public User findUserById(Long id) throws Exception {
        Optional<User> opt = userRepository.findById(id);

        if(opt.isPresent()){
            return opt.get();
        }

       throw new Exception("User not found");
    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {

       String email = jwtProvider.getEmailFromJwtToken(jwt);
        if(email == null){
            throw new Exception("Provide valid JWT token");
        }

        User user = userRepository.findByEmail(email);

        if(user == null){
            throw new Exception("Not found");
        }

       return user;
    }

}
