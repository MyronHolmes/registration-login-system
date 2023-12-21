package com.myprojects.rls.repository;

import com.myprojects.rls.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findAllByName(String name);
}
