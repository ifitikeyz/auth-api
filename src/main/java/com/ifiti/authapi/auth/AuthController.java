package com.ifiti.authapi.auth;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import com.ifiti.authapi.auth.dto.RegisterRequest;
import com.ifiti.authapi.auth.dto.RegisterResponse;
import com.ifiti.authapi.service.AuthService;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthController {

    private final AuthService authService;
    public AuthController(AuthService authService){
        this.authService = authService;
    }


    @PostMapping("/api/auth/register")
    public ResponseEntity<RegisterResponse> register(
            @RequestBody RegisterRequest request){
        RegisterResponse response = authService.register(request);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);

    }


}
