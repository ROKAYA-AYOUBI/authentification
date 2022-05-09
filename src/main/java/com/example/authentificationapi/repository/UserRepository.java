package com.example.authentificationapi.repository;

import com.example.authentificationapi.models.Role;
import com.example.authentificationapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository   extends JpaRepository<User, Long> {
  Optional<User> findByUsername(String username);
    //Optional<User> findById(Long id);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
/*
    @Query("SELECT user FROM User user LEFT JOIN user.roles role WHERE role.id = ?1")
    List<User> findUserByRole(Long role);

    @Query( "select user from User user inner join user.roles role where role.name in :names" )
    List<User> findBySpecificRoles(@Param("names") List<Role> names);
*/

}
