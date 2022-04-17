package pt.bmo.restaurant.ordering.auth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pt.bmo.restaurant.ordering.auth.model.LoginRequest;
import pt.bmo.restaurant.ordering.auth.model.User;
import pt.bmo.restaurant.ordering.auth.service.LoginService;

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody LoginRequest request) {

        User user = loginService.generateUserToken(request);
        return ResponseEntity.ok(user);
    }
}
