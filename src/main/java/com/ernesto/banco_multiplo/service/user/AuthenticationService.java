package com.ernesto.banco_multiplo.service.user;

import com.ernesto.banco_multiplo.entity.user.AuthenticationDTO;
import com.ernesto.banco_multiplo.entity.user.LoginResponseDTO;
import com.ernesto.banco_multiplo.entity.user.User;
import com.ernesto.banco_multiplo.infra.security.TokenService;
import com.ernesto.banco_multiplo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public ResponseEntity<?> login(AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}
