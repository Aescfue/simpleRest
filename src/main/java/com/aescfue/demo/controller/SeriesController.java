package com.aescfue.demo.controller;

import com.aescfue.demo.model.Serie;
import com.aescfue.demo.model.SerieConValoracionMedia;
import com.aescfue.demo.service.SerieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/series")
public class SeriesController {

    @Autowired
    private SerieService serieService;

    @GetMapping
    public List<Serie> listarSeries() {
        return serieService.obtenerSeries();
    }

    @PostMapping
    public Serie agregarSerie(@RequestBody Serie serie) {
        return serieService.agregarSerie(serie);
    }

    @GetMapping("/top")
    public List<SerieConValoracionMedia> obtenerTopSeries() {
        return serieService.obtenerTopSeries();
    }
}
