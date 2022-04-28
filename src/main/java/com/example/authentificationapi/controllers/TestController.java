package com.example.authentificationapi.controllers;


import com.example.authentificationapi.models.User;
import com.example.authentificationapi.repository.RoleRepository;
import com.example.authentificationapi.repository.UserRepository;
import com.example.authentificationapi.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;

//affiche tout les users

    @GetMapping(value="/users")
    public List listUser(){
        return userRepository.findAll();
    }
    @GetMapping(value="/users/{id}/role")
    public List listRole(){
        return roleRepository.findAll();
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
