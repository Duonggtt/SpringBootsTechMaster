package com.example.demosecucustomuser.repository;

import com.example.demosecucustomuser.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
