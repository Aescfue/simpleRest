package com.aescfue.demo.controller;

import com.aescfue.demo.exception.ResourceNotFoundException;
import com.aescfue.demo.model.Serie;
import com.aescfue.demo.model.Valoracion;
import com.aescfue.demo.repository.SerieRepository;
import com.aescfue.demo.repository.ValoracionRepository;
import com.aescfue.demo.service.ValoracionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/valoraciones")
public class ValoracionController {

    @Autowired
    private ValoracionService valoracionService;
    @Autowired
    private SerieRepository serieRepository;
    @Autowired
    private ValoracionRepository valoracionRepository;

    @GetMapping
    public List<Valoracion> listarValoraciones() {
        return valoracionService.obtenerValoraciones();
    }

    @PostMapping
    public ResponseEntity<Valoracion> crearValoracion(@RequestBody Valoracion nuevaValoracion) {


        // Buscar la serie usando el ID
        Serie serie = serieRepository.findById(nuevaValoracion.getSerie().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Serie no encontrada"));

        nuevaValoracion.setSerie(serie); // Asigna la serie a la valoración

        Valoracion guardada = valoracionRepository.save(nuevaValoracion);
        return ResponseEntity.status(HttpStatus.CREATED).body(guardada);
    }

}
