package com.myprojects.rls.service;

import com.myprojects.rls.dto.UserDto;
import com.myprojects.rls.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findByEmail(String email);
}
