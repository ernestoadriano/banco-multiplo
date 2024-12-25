package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.crud.model.Cliente;
import com.ernesto.banco_multiplo.crud.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente insert(Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    public Cliente update(Cliente cliente) {
        return clienteRepository.saveAndFlush(cliente);
    }

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getByNome(String nome) {
        return clienteRepository.findByNome(nome)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado!"));
    }

    public String delete(Long id) {
        Cliente cliente = getById(id);
        clienteRepository.delete(cliente);
        return "Cliente " + cliente.getNome() + " " + cliente.getApelido() + " removido com sucesso!";
    }
}
