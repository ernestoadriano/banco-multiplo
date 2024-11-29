package com.ernesto.banco_multiplo.controller;

import com.ernesto.banco_multiplo.model.Residencia;
import com.ernesto.banco_multiplo.service.ResidenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/residencia")
public class ResidenciaController {

    @Autowired
    private ResidenciaService residenciaService;

    @GetMapping("/getAll")
    public List<Residencia> getAll() {
        return residenciaService.getAll();
    }

    @GetMapping("get/{id}")
    public Residencia getById(@PathVariable("id") Long id) {
        return residenciaService.getById(id);
    }

    @PostMapping("/insert")
    public List<Residencia> insert(@RequestBody Residencia residencia) {
        return residenciaService.insert(residencia);
    }

    @PutMapping("/update")
    public List<Residencia> update(@RequestBody Residencia residencia) {
        return residenciaService.update(residencia);
    }

    @DeleteMapping("/delete/{id}")
    public List<Residencia> delete(@PathVariable("id") Long id) {
        return residenciaService.delete(id);
    }
}
