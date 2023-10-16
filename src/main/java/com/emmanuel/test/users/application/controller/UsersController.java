package com.emmanuel.test.users.application.controller;


import com.emmanuel.test.users.application.service.UsersService;
import com.emmanuel.test.users.domain.dto.ResponseDTO;
import com.emmanuel.test.users.domain.dto.UsersDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UsersService usersService;

    @GetMapping
    public ResponseDTO getAllUsers() {
        return usersService.getAllUSers();
    }

    @PostMapping("/user")
    public ResponseDTO saveUser(@RequestBody UsersDto user) {
        return this.usersService.saveUser(user);
    }

    @PutMapping("/user/{userId}")
    public ResponseDTO updateUser(@RequestBody UsersDto user,@PathVariable String userId) {
        user.setUserId(userId);
        return this.usersService.updateUser(user);
    }

    @GetMapping("/user/{userId}")
    public ResponseDTO ResponseDTOgetUserById(@PathVariable String userId) {
        return this.usersService.getUserById(userId);
    }
    @DeleteMapping("/user/{userId}")
    public ResponseDTO deletUser(@PathVariable String userId) {
        return this.usersService.deleteUser(userId);
    }


}
