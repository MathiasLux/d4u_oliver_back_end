package com.d4u.Decision4You.presentation;

import com.d4u.Decision4You.presentation.views.Views;
import com.d4u.Decision4You.security.web.SecurityUser;
import com.d4u.Decision4You.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor

public class UserController {

    // private final Logger LOGGER = LoggerFactory.getLogger(UserRegistrationController.class);
    private final UserService userService;


    /**
     * Logs in the user.
     *
     * @return 200 OK with the user's login information
     */
    @GetMapping
    public Views.LoginView login(@AuthenticationPrincipal SecurityUser principal) {
        return userService.login(principal.getUser());
    }
}
