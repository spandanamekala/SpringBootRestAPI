package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class WishController {


    @Autowired
    UserService userService;

    @PostMapping
    public List<User> createUser(@RequestBody List<User> userList) {
        return userService.createUser(userList);

    }



    @GetMapping
    public List<User> getUsers(@RequestParam(value = "name", required = false) String name)
    {
        return userService.getUsers(name);
   }


    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {

        return userService.getUser(id);
    }




}