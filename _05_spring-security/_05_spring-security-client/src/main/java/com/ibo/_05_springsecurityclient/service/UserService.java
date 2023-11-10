package com.ibo._05_springsecurityclient.service;

import com.ibo._05_springsecurityclient.entity.User;
import com.ibo._05_springsecurityclient.model.UserModel;

public interface UserService {


    User registerUser(UserModel userModel);

    void saveVerificationTokenForUser(String token, User user);

    String validateVerificationToken(String token);

}
