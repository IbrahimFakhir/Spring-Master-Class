package com.ibo._05_springsecurityclient.controller;

import com.ibo._05_springsecurityclient.entity.User;
import com.ibo._05_springsecurityclient.model.UserModel;
import com.ibo._05_springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel) {
        User user = userService.registerUser(userModel);

        return "Success";
    }

}
