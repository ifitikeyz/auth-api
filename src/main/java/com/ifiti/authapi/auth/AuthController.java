package com.ifiti.authapi.auth;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;

@RestController


public class AuthController {

    @PostMapping("/api/auth/register")
    ResponseEntity<String> register(){
        return ResponseEntity.ok("Registeration successful");
    }

}
