package com.aescfue.demo.model;

import lombok.Getter;
import lombok.Setter;

public class SerieConValoracionMedia {
    @Getter
    private Long id;
    @Getter
    private String nombre;
    @Getter
    private String plataforma;
    @Getter
    private String sinopsis;
    @Getter
    private String caratulaUrl;
    @Getter
    private Double mediaValoracion;

    public SerieConValoracionMedia(Long id, String nombre, String plataforma, String sinopsis, String caratulaUrl, Double mediaValoracion) {
        this.id = id;
        this.nombre = nombre;
        this.plataforma = plataforma;
        this.sinopsis = sinopsis;
        this.caratulaUrl = caratulaUrl;
        this.mediaValoracion = mediaValoracion;
    }

}
