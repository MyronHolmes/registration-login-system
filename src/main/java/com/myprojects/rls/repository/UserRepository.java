package com.myprojects.rls.repository;

import com.myprojects.rls.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findAllByEmail(String email);
}
