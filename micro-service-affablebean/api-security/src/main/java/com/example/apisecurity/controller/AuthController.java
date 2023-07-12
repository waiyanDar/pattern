package com.example.apisecurity.controller;

import com.example.apisecurity.data.User;
import com.example.apisecurity.data.UserDao;
import com.example.apisecurity.exception.PasswordNotMatchError;
import com.example.apisecurity.service.AuthService;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello";
    }

    record RequestUser(@JsonProperty("first_name") String firstName,
                       @JsonProperty("last_name") String lastName,
                       String email, String password,
                       @JsonProperty("confirm_password") String confirmPassword) {}

    record RegisterResponseUser(@JsonProperty("first_name") String firstName,
                                @JsonProperty("last_name") String lastName,String email){}

    @PostMapping("/register")
    public RegisterResponseUser register(@RequestBody RequestUser requestUser) {

        User user =  authService.register(
                requestUser.firstName(), requestUser.lastName(), requestUser.email(), requestUser.password(),requestUser.confirmPassword()
        );
        return new RegisterResponseUser(user.getFirstName(), user.getLastName(), user.getEmail());
    }
}
