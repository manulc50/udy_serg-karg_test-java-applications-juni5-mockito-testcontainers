package com.mlorenzo.estore.service;

import com.mlorenzo.estore.model.User;

public interface UserService {
    User createUser(String firstName, String lastName, String email, String password,
                    String repeatPassword);
}
