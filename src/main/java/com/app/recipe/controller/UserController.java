package com.app.recipe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.recipe.service.UserService;

import com.app.recipe.model.User;
// import com.app.recipe.repository.UserRepository;
// import java.util.List;


@RestController
public class UserController {

    //@Autowired
    //private UserRepository userRepository;

    // @PostMapping("/users")
    // public User createUser(@RequestBody User user){

    //     User uExist = userRepository.findByEmail(user.getEmail());
    //     if(uExist != null){
    //         try {
    //             throw new Exception("Email already in use");
    //         } catch (Exception e) {
    //             e.printStackTrace();
    //         }
    //     }

    //     User savedUser =  userRepository.save(user);
        
    //     return savedUser;
    // }

    // @DeleteMapping("/users/{userId}")
    // public String deleteUser(@PathVariable Long userId) throws Exception{
    //         userRepository.deleteById(userId);
    //         return "User deleted successfully";
    // }


    // @GetMapping("/users")
    // public List<User> getAllUsers() throws Exception{
    //     List<User> users = userRepository.findAll();
    //     return users;
    // }
   

    @Autowired
    private UserService userService;

    @GetMapping("/api/users/profile")
    public User findUserByJwt(@RequestHeader("Authorization") String jwt) throws Exception{

        User user = userService.findUserByJwt(jwt);
        return user;

    }
}
