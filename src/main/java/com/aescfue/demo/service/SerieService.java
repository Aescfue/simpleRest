package com.aescfue.demo.service;

import com.aescfue.demo.model.Serie;
import com.aescfue.demo.model.SerieConValoracionMedia;
import com.aescfue.demo.repository.SerieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService {

    @Autowired
    private SerieRepository serieRepository;

    public List<Serie> obtenerSeries() {
        return serieRepository.findAll();
    }

    public Serie agregarSerie(Serie serie) {
        return serieRepository.save(serie);
    }

    public Serie obtenerSeriePorId(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    public List<SerieConValoracionMedia> obtenerTopSeries() {
        return serieRepository.findAllOrderByAverageRating();
    }
}
