package com.aescfue.demo.repository;

import com.aescfue.demo.model.Serie;
import com.aescfue.demo.model.SerieConValoracionMedia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SerieRepository extends JpaRepository<Serie, Long> {

    @Query("SELECT new com.aescfue.demo.model.SerieConValoracionMedia(s.id, s.nombre, s.plataforma, s.sinopsis, s.caratulaUrl, AVG(v.puntuacion)) " +
            "FROM Serie s LEFT JOIN s.valoraciones v " +
            "GROUP BY s.id ORDER BY AVG(v.puntuacion) DESC")
    List<SerieConValoracionMedia> findAllOrderByAverageRating();
}
