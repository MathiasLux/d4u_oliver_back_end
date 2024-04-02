package com.d4u.Decision4You.service;


import com.d4u.Decision4You.domain.user.Profile;
import com.d4u.Decision4You.domain.user.User;
import com.d4u.Decision4You.persistence.UserRepository;
import com.d4u.Decision4You.presentation.commands.Commands;
import com.d4u.Decision4You.presentation.views.Views;
import com.d4u.Decision4You.security.password.PasswordService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import static com.d4u.Decision4You.domain.user.Role.USER;

@Service
@RequiredArgsConstructor
public class UserRegistrationService {

    private final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationService.class);

    // Helps us to retrieve users from the database.
    private final UserQueryService userQueryService;

    // Helps us to hash passwords and check password strength.
    private final PasswordService passwordService;

    // Helps us to save users in the database.
    private final UserRepository userRepository;


    // Register User
    // --------------------------------------------------------------------------------------------
    public Views.UserRegisteredView register(Commands.UserRegistrationCommand command) {
        LOGGER.debug("User registration {}", command);

        // 1. Check if email is not taken if not throw exception
        userQueryService.checkEmailNotTaken(command.email());

        // 2. Check password strength / hash password
        var encodedPassword = passwordService.encode(command.password());

        // 3. Instantiate/save user (with account disabled!) in DB
        var user = createUserFrom(command, encodedPassword);
        var savedUser = userRepository.save(user);

        LOGGER.debug("User registration successful {}", user);
        return new Views.UserRegisteredView(savedUser.getId());
    }


    // Private Helper Methods for Domain Layer Logic
    // --------------------------------------------------------------------------------------------

    private User createUserFrom(Commands.UserRegistrationCommand command, PasswordService.EncodedPassword password) {
        var profile = new Profile(command.firstName(), command.lastName());
        return new User(command.email(), password, USER, profile);
    }
}
