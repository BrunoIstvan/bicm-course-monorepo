package br.com.bicmsystems.bicmoauth.controllers;

import br.com.bicmsystems.bicmoauth.entities.UserModel;
import br.com.bicmsystems.bicmoauth.exceptions.UserNotFoundException;
import br.com.bicmsystems.bicmoauth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {

        try {
            UserModel user = userService.findByEmail(email);
            return ResponseEntity.ok(user);
        } catch (UserNotFoundException e) {
            return ResponseEntity.notFound().build();
        }

    }

}