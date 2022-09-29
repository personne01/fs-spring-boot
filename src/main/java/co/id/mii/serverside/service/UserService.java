/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.service;

import co.id.mii.serverside.model.Role;
import co.id.mii.serverside.model.User;
import co.id.mii.serverside.model.dto.request.AddRoleUserRequest;
import co.id.mii.serverside.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author MSI-JO
 */
@Service
public class UserService {

    private UserRepository userRepository;
    private RoleService roleService;

    @Autowired
    public UserService(UserRepository userRepository, RoleService roleService) {
        this.userRepository = userRepository;
        this.roleService = roleService;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "user not Found"));
    }

    public User update(Long id, User user) {
        User oldUser = getById(id);
        if (!oldUser.getUsername().equals(user.getUsername())) {
            findByName(user.getUsername());
        }
        user.setId(id);
        user.setEmployee(oldUser.getEmployee());
        user.setRoles(oldUser.getRoles());
        return userRepository.save(user);
    }

    public User delete(Long id) {
        User user = getById(id);
        userRepository.delete(user);
        return user;
    }

    public void findByName(String name) {
        if (userRepository.findByUsername(name).isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists");
        }
    }

    public User addRole(AddRoleUserRequest addRoleUserRequest) {
        User user = getById(addRoleUserRequest.getUserId());
        List<Role> roles = user.getRoles();
        addRoleUserRequest.getRoles().forEach(role -> {
            roles.add(roleService.findByName(role));
        });
        user.setRoles(roles);
        return userRepository.save(user);
    }

}
