package com.ada.olimpiadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Categoria;
import com.ada.olimpiadas.models.TipoPuntaje;
import com.ada.olimpiadas.repositories.ICategoriaRepository;
import com.ada.olimpiadas.repositories.ITipoPuntajeRepository;



@RestController
@RequestMapping("/TipoPuntaje")
public class TipoPuntajeController {

    @Autowired
    private ITipoPuntajeRepository tipoPuntajeRepository;

    @GetMapping(path = "/TipoPuntajePorModalidad/{modalidadID}")
    public TipoPuntaje TipoPuntajePorModalidad(@PathVariable int modalidadID) {
        return tipoPuntajeRepository.TipoPuntajePorModalidad(modalidadID);
    }
    
}
