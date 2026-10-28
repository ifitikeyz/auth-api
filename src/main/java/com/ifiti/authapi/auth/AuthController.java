package com.ifiti.authapi.auth;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.ifiti.authapi.auth.dto.RegisterResponse;

@RestController


public class AuthController {

    @PostMapping("/api/auth/register")
    ResponseEntity<RegisterResponse> register(){
        return ResponseEntity.status(HttpStatus.CREATED)
                .body();

    }

}
