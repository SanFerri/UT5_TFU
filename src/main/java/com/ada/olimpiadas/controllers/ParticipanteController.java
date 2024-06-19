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
import com.ada.olimpiadas.repositories.IJuezRepository;
import com.ada.olimpiadas.repositories.IParticipanteRepository;

@RestController
@RequestMapping("/juez")
public class ParticipanteController {

    private IParticipanteRepository participanteRepository;

    @Autowired
    public ParticipanteController(IParticipanteRepository participanteRepository) {
        this.participanteRepository = participanteRepository;
    }

    @GetMapping(path = "/listaParticipantes")
    public @ResponseBody LinkedList<Participante> getParticipantes() {
        return participanteRepository.getParticipantes();
    }

    @GetMapping(path = "listaParticipantes/{id}")
    public @ResponseBody Participante getParticipantesID(@PathVariable int id) {
        return participanteRepository.getParticipante(id);
    }

}
