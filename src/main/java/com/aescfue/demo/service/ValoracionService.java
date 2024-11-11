package com.aescfue.demo.service;

import com.aescfue.demo.model.Serie;
import com.aescfue.demo.model.Valoracion;
import com.aescfue.demo.repository.ValoracionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ValoracionService {

    @Autowired
    private ValoracionRepository valoracionRepository;

    public List<Valoracion> obtenerValoraciones() {
        return valoracionRepository.findAll();
    }

    public Valoracion agregarValoracion(Valoracion valoracion) {
        return valoracionRepository.save(valoracion);
    }
}
