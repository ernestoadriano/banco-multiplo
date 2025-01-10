package com.ernesto.banco_multiplo.controller;

/*import com.ernesto.banco_multiplo.entity.user.AuthenticationDTO;
import com.ernesto.banco_multiplo.entity.user.LoginResponseDTO;
import com.ernesto.banco_multiplo.entity.user.RegisterDTO;
import com.ernesto.banco_multiplo.entity.user.User;
import com.ernesto.banco_multiplo.infra.security.TokenService;
import com.ernesto.banco_multiplo.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;*/
/*
 * @author: Ernesto Adriano
 * */
/*@RestController
@RequestMapping("/auth")*/
public class AuthenticationController {

   /* @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody RegisterDTO dto) {
        if (this.repository.findByLogin(dto.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = new User(dto.login(), encryptedPassword, dto.role());

        repository.save(user);

        return ResponseEntity.ok().build();
    }*/
}
