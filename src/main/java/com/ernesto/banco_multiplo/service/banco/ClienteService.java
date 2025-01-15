package com.ernesto.banco_multiplo.service.banco;

import com.ernesto.banco_multiplo.entity.banco.Cliente;
import com.ernesto.banco_multiplo.entity.enums.UserRole;
import com.ernesto.banco_multiplo.entity.user.User;
import com.ernesto.banco_multiplo.repository.banco.ClienteRepository;
import com.ernesto.banco_multiplo.repository.user.UserRepository;
import com.ernesto.banco_multiplo.service.PasswordUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * @author: Ernesto Adriano
 * */
@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    private UserRepository userRepository;

    public List<Cliente> getAll() {
        return repository.findAll();
    }

    public Cliente getBynumBi(String bi) {
        return repository.findByNumBi(bi)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente getById(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
    }

    public Cliente insert(Cliente cliente) {
        String password = new PasswordUtil().generatePassword();
        String encryptedPassword = new BCryptPasswordEncoder().encode(password);
        User user = new User(cliente.getEmail(), encryptedPassword, UserRole.USER);
        cliente.setUser(user);
        userRepository.saveAndFlush(user);
        return repository.saveAndFlush(cliente);
    }

    public Cliente update(String id, Cliente cliente) {

        Cliente cl = getById(id);
        if (cliente.getNomeCompleto() != null)
            cl.setNomeCompleto(cliente.getNomeCompleto());
        if (cliente.getDataNascimento() != null)
            cl.setDataNascimento(cliente.getDataNascimento());
        if (cliente.getNumBi() != null)
            cl.setNumBi(cliente.getNumBi());
        if (cliente.getResidencia() != null)
            cl.setResidencia(cliente.getResidencia());
        if (cliente.getTelefone() != null)
            cl.setTelefone(cliente.getTelefone());
        if (cliente.getEmail() != null)
            cl.setEmail(cliente.getEmail());
        if (cliente.getUser() != null)
            cl.setUser(cliente.getUser());

        return repository.saveAndFlush(cl);
    }

    public String delete(String id) {
        Cliente cliente = getById(id);
        repository.delete(cliente);
        return "O cliente " + cliente.getNomeCompleto() + " foi excluído!";
    }
}
