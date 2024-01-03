package com.myprojects.rls.service;

import com.myprojects.rls.dto.UserDto;
import com.myprojects.rls.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);

    List<UserDto> findAllUsers();
}
