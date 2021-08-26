package br.com.bicmsystems.bicmuser.controllers;

import br.com.bicmsystems.bicmuser.entities.UserModel;
import br.com.bicmsystems.bicmuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        Optional<UserModel> user = userRepository.findById(id);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());

        return ResponseEntity.notFound().build();
    }

    @GetMapping("/search")
    public ResponseEntity<?> findByEmail(@RequestParam String email) {

        Optional<UserModel> user = userRepository.findByEmail(email);
        if(user.isPresent())
            return ResponseEntity.ok(user.get());

        return ResponseEntity.notFound().build();
    }

}
