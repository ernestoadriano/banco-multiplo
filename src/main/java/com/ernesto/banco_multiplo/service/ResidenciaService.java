package com.ernesto.banco_multiplo.service;

import com.ernesto.banco_multiplo.model.Residencia;
import com.ernesto.banco_multiplo.repository.ResidenciaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResidenciaService {

    @Autowired
    private ResidenciaRepository residenciaRepository;

    public List<Residencia> getAll() {
        return residenciaRepository.findAll();
    }

    public Residencia getById(Long id) {
        return residenciaRepository.findById(id).get();
    }

    public List<Residencia> insert(Residencia residencia) {
        residenciaRepository.saveAndFlush(residencia);
        return residenciaRepository.findAll();
    }

    public List<Residencia> update(Residencia residencia) {
        residenciaRepository.saveAndFlush(residencia);
        return residenciaRepository.findAll();
    }

    public List<Residencia> delete(Long id) {
        Residencia residencia = residenciaRepository.findById(id).get();
        residenciaRepository.delete(residencia);
        return residenciaRepository.findAll();
    }
}
