package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.entity.banco.Cliente;
import com.ernesto.banco_multiplo.entity.enums.UserRole;
import com.ernesto.banco_multiplo.entity.user.AuthenticationDTO;
import com.ernesto.banco_multiplo.entity.user.LoginResponseDTO;
import com.ernesto.banco_multiplo.entity.user.RegisterDTO;
import com.ernesto.banco_multiplo.entity.user.User;
import com.ernesto.banco_multiplo.infra.security.TokenService;
import com.ernesto.banco_multiplo.repository.user.UserRepository;
import com.ernesto.banco_multiplo.service.PasswordUtil;
import com.ernesto.banco_multiplo.service.banco.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

/*
 * @author: Ernesto Adriano
 * */
@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository repository;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private ClienteService clienteService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthenticationDTO dto) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(dto.login(), dto.password());
        var auth = authenticationManager.authenticate(usernamePassword);

        var token = tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        if (this.repository.findByLogin(dto.login()) != null) return ResponseEntity.badRequest().build();

        String encryptedPassword = new BCryptPasswordEncoder().encode(dto.password());
        User user = new User(dto.login(), encryptedPassword, dto.role());

        repository.save(user);

        return ResponseEntity.ok().build();
    }
    /*@PostMapping("/register_cliente/{id_cliente}")
    public ResponseEntity<?> register(@PathVariable("id_cliente") String id) {
        Cliente cliente = clienteService.getById(id);
        if (this.repository.findByLogin(cliente.getEmail()) != null) return ResponseEntity.badRequest().build();

        String password = new PasswordUtil().generatePassword();
        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        User user = new User(cliente.getEmail(), encryptedPassword, UserRole.USER);
        repository.saveAndFlush(user);
        return ResponseEntity.ok().build();
    }*/
}
