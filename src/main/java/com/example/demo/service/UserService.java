package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {


    private List<User> users = new ArrayList<>();

    public List<User> getUsers(String name)
    {
        if (name !=null){
            return users.stream()
                    .filter(user->user.getName().toLowerCase().contains(name.toLowerCase()))
                    .collect(Collectors.toList());
        }
        else{
            return users;// no filter, retuyrn all users
        }

    }



    public List<User> createUser(List<User> userList) {
        users.addAll(userList);
        return userList;
    }


    public User getUser(Long id) {
        for(User user : users)
        {
            if (user.getId().equals(id)) {
                return user;  // Return the whole user object
            }
        }
        return null;
    }
}
