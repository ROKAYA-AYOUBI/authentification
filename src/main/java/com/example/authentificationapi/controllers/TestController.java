package com.example.authentificationapi.controllers;


import com.example.authentificationapi.exception.BusinessResourceException;
import com.example.authentificationapi.exception.ResourceNotFoundException;
import com.example.authentificationapi.models.ERole;
import com.example.authentificationapi.models.Role;
import com.example.authentificationapi.models.User;
import com.example.authentificationapi.repository.RoleRepository;
import com.example.authentificationapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    RoleRepository roleRepository;



   //--------------------------------CRUD------------------------------
  //affiche tout les users
   @GetMapping(value="/users")
   // @PreAuthorize("hasRole('ADMIN')")
   public ResponseEntity<Page<User>> getAll(Pageable pageable) {
       return ResponseEntity.ok(userRepository.findAll(pageable));
   }

    // affiche user par id
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUsersById(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user =
                userRepository
                        .findById(userId)
                        .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));
        return ResponseEntity.ok().body(user);
    }


    //update user
    // @PreAuthorize("hasRole('ADMIN')")
    @PutMapping(value="/users/{id}")
    public User update(@PathVariable(name="id")Long id , @RequestBody User user ){
        user.setId(id);
        return userRepository.save(user);

    }

    // delete user par id
    // @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping(value = "/users/{id}")
    public void delete(@PathVariable(name="id") Long id){
        userRepository.deleteById(id);
    }

  //----------------------------------------------------------------------

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
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
