package com.ibo._05_springsecurityclient.controller;

import com.ibo._05_springsecurityclient.entity.User;
import com.ibo._05_springsecurityclient.event.RegistrationCompleteEvent;
import com.ibo._05_springsecurityclient.model.UserModel;
import com.ibo._05_springsecurityclient.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class RegistrationController {

    @Autowired
    private UserService userService;

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel userModel, final HttpServletRequest request) {
        User user = userService.registerUser(userModel);

        publisher.publishEvent(new RegistrationCompleteEvent(
                user,
                applicationUrl(request)
        ));

        return "Success";
    }

    private String applicationUrl(HttpServletRequest request) {
        return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    }

}
