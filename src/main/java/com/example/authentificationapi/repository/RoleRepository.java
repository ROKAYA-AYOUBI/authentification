package com.example.authentificationapi.repository;

import java.util.Optional;
import com.example.authentificationapi.models.Role;
import com.example.authentificationapi.models.ERole;
import com.example.authentificationapi.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;




@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
    Optional<Role> findById(Long id);

    ResponseEntity<Object> updateRole(Long id, javax.management.relation.Role role);
}
