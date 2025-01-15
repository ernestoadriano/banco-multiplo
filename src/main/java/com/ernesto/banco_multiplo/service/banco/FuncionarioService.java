package com.ernesto.banco_multiplo.service.banco;


import com.ernesto.banco_multiplo.entity.banco.Funcionario;
import com.ernesto.banco_multiplo.entity.enums.UserRole;
import com.ernesto.banco_multiplo.entity.user.User;
import com.ernesto.banco_multiplo.repository.banco.FuncionarioRepository;
import com.ernesto.banco_multiplo.repository.user.UserRepository;
import com.ernesto.banco_multiplo.service.PasswordUtil;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
/*
 * @author: Ernesto Adriano
 * */
@Service
public class FuncionarioService {

    /*@Autowired
    private JavaMailSender mailSender;*/

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private UserRepository userRepository;

    /*public void enviarEmail(String para, String nome) throws MessagingException {
        String pin = "12345";
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(para);
        helper.setSubject("Seu PIN de acesso");
        helper.setText(String.format("""
            Olá, %s!
           \s
            Seu PIN de acesso é: %s
           \s
            Por favor, não compartilhe este código.
       \s""", nome, pin), false);

        mailSender.send(message);
    }*/

    public List<Funcionario> getAll() {
        return funcionarioRepository.findAll();
    }

    public Funcionario getByNumBi(String bi) {
        return funcionarioRepository.findByNumBi(bi)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario getById(String id) {
        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Funcionário não encontrado!"));
    }

    public Funcionario insert(Funcionario funcionario) {
        String password = new PasswordUtil().generatePassword();
        String encyptedPassord = new BCryptPasswordEncoder().encode(password);
        User user = new User(funcionario.getEmail(), encyptedPassord, UserRole.ADMIN);
        funcionario.setUser(user);
        userRepository.saveAndFlush(user);
        return funcionarioRepository.saveAndFlush(funcionario);
    }

    public Funcionario update(String id, Funcionario funcionario) {
        Funcionario fun = getById(id);
        if (funcionario.getNomeCompleto() != null)
            fun.setNomeCompleto(funcionario.getNomeCompleto());
        if (funcionario.getDataNascimento() != null)
            fun.setDataNascimento(funcionario.getDataNascimento());
        if (funcionario.getNumBi() != null)
            fun.setNumBi(funcionario.getNumBi());
        if (funcionario.getResidencia() != null)
            fun.setResidencia(funcionario.getResidencia());
        if (funcionario.getTelefone() != null)
            fun.setTelefone(funcionario.getTelefone());
        if (funcionario.getEmail() != null)
            fun.setEmail(funcionario.getEmail());
        if (funcionario.getFuncao() != null)
            fun.setFuncao(funcionario.getFuncao());

        return funcionarioRepository.saveAndFlush(fun);
    }

    public String delete(String id) {
        Funcionario funcionario = getById(id);
        funcionarioRepository.delete(funcionario);
        return "Funcionário " + funcionario.getNomeCompleto() +" excluído!";
    }
}
