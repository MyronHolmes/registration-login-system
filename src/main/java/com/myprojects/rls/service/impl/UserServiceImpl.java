package com.myprojects.rls.service.impl;

import com.myprojects.rls.dto.UserDto;
import com.myprojects.rls.entity.Role;
import com.myprojects.rls.entity.User;
import com.myprojects.rls.repository.RoleRepository;
import com.myprojects.rls.repository.UserRepository;
import com.myprojects.rls.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public void saveUser(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
//        encrypt the password using spring security
        user.setPassword(userDto.getPassword());

        Role role = roleRepository.findAllByName("ROLE_ADMIN");

        if(role == null){
            role = checkRoleExist();
        }
        user.setRoles(Arrays.asList(role));
        userRepository.save(user);
    }
    private Role checkRoleExist(){
        Role role = new Role();
        role.setName("ROLE_ADMIN");
        return roleRepository.save(role);
    }
}
