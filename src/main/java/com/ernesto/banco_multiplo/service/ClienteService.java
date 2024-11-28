package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.Cliente;
import com.ernesto.banco_multiplo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    public Cliente getById(Long id) {
        return clienteRepository.findById(id).get();
    }

    public List<Cliente> jinsert(Cliente cliente) {
        cliente.setData_registo(new Date());
        clienteRepository.saveAndFlush(cliente);
        return getAll();
    }

    public List<Cliente> update(Cliente cliente) {
        clienteRepository.saveAndFlush(cliente);
        return getAll();
    }

    public List<Cliente> delete(Long id) {
        Cliente cliente = clienteRepository.findById(id).get();
        clienteRepository.delete(cliente);
        return getAll();
    }
}
