package com.ifiti.authapi.service;
import com.ifiti.authapi.auth.dto.RegisterRequest;
import com.ifiti.authapi.auth.dto.RegisterResponse;
import org.springframework.stereotype.Service;
import com.ifiti.authapi.user.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.ifiti.authapi.user.User;


@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    public RegisterResponse register(RegisterRequest request){

        if(userRepository.existsByEmail(request.getEmail())){
            throw new IllegalArgumentException("Email is already registered");
        }
        String passwordHash = passwordEncoder.encode(request.getPassword());
        User user = new User(
                request.getName().trim(),
                request.getEmail().trim().toLowerCase(),
                passwordHash,
                "USER"
        );

        User savedUser = userRepository.save(user);

        return new RegisterResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole()
        );



    }

}
