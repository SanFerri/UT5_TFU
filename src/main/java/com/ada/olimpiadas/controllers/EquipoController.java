package com.ada.olimpiadas.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Equipo;
import com.ada.olimpiadas.repositories.IEquipoRepository;

@RestController
@RequestMapping("/equipos")
public class EquipoController {

    private IEquipoRepository equipoRepository;

    @Autowired
    public EquipoController(IEquipoRepository equipoRepository) {
        this.equipoRepository = equipoRepository;
    }

    @GetMapping(path = "/listaEquipos")
    public @ResponseBody LinkedList<Equipo> getEquipos() {
        return equipoRepository.getEquipos();
    }
    
}
