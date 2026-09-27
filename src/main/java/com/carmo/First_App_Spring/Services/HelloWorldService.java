package com.carmo.First_App_Spring.Services;

import com.carmo.First_App_Spring.Domain.User;
import org.springframework.stereotype.Service;

@Service
public class HelloWorldService {

    public String helloName(User user) {
        return "Hello " + user.getName() + " Welcome!";
    }

}
