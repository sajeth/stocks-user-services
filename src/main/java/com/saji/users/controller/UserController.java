package com.saji.users.controller;

import com.saji.users.pojo.UserPojo;
import com.saji.users.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
@RequestMapping("/kite")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public @ResponseBody
    List<UserPojo> getUsersList() {
        return userService.listUsers();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    UserPojo getLov(@PathVariable String id) {
        return userService.findUser(id);
    }

    @PostMapping("/new")
    public @ResponseBody
    void createNewUser(@RequestBody UserPojo pojo) {
        userService.addUser(pojo);
    }

    @PutMapping("/{id}")
    public @ResponseBody
    void updateUser(@PathVariable BigInteger id, @RequestBody UserPojo pojo) {
        userService.updateUser(pojo, id);
    }

    @DeleteMapping("/{id}")
    public @ResponseBody
    void deleteUser(@PathVariable BigInteger id) {
        userService.deleteUser(id);
    }
}
