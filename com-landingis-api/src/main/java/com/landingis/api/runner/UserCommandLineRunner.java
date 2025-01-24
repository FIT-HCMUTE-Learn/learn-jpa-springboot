package com.landingis.api.runner;

import com.landingis.api.entity.User;
import com.landingis.api.repository.UserRepository;
import com.landingis.api.service.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.logging.Logger;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = Logger.getLogger(UserCommandLineRunner.class.getName());

    @Autowired
    private UserService userService;

    @Override
    public void run(String... args) throws Exception {
        DemoFindUser();
    }

    private void DemoCreateUser(){
        User user = User.builder()
                .name("Paul")
                .role("ADMIN")
                .build();

        User insertedUser = userService.save(user);

        logger.info("Inserted user: " + user.toString());
    }

    private void DemoFindUser(){
        Optional<User> users = userService.findById(1L);

        logger.info("Found user: " + users.toString());
    }
}
