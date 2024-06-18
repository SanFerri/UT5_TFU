package com.ada.olimpiadas.controllers;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Juez;
import com.ada.olimpiadas.models.Participante;
import com.ada.olimpiadas.repositories.IJuezRepositorie;

@RestController
@RequestMapping("/juez")
public class JuezController {

    private IJuezRepositorie juezRepository;

    @Autowired
    public JuezController(IJuezRepositorie juezRepository) {
        this.juezRepository = juezRepository;
    }

    @GetMapping(path = "/listaJueces")
    public @ResponseBody LinkedList<Juez> getJueces() {
        return juezRepository.getJueces();
    }

    @GetMapping(path = "listaJueces/{id}")
    public @ResponseBody Juez getJuecesID(@PathVariable int id) {
        return juezRepository.getJuez(id);
    }

    @GetMapping(path = "/listaParticipantes")
    public @ResponseBody LinkedList<Participante> getParticipantes() {
        return juezRepository.getParticipantes();
    }

    @GetMapping(path = "listaParticipantes/{id}")
    public @ResponseBody Participante getParticipantesID(@PathVariable int id) {
        return juezRepository.getParticipante(id);
    }

}