package com.example.authentificationapi.controllers;


import com.example.authentificationapi.models.User;
import com.example.authentificationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;

//affiche tout les users
    @GetMapping(value="/all")
    public List listUser(){
        return userRepository.findAll();
    }
// affiche par id
    @GetMapping(value="/users/{id}")
   public  User listusers(@PathVariable(name="id") Long id){
        return userRepository.findById(id).get();
    }
    // delete user par id
    // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable(name="id") Long id){
        userRepository.deleteById(id);
    }

//update user
    
    // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/users/{id}")
    public User update(@PathVariable(name="id")Long id , @RequestBody User user ){
        user.setId(id);
        return userRepository.save(user);

    }

/*
   // @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value="/users/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable(value = "id") Long id){
        userRepository.delete(id);
        return new User(id);
    }
*/



    @GetMapping("/user")
    //@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
   // @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
   // @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }
}
