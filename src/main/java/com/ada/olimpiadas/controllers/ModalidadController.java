package com.ada.olimpiadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Modalidad;
import com.ada.olimpiadas.repositories.IModalidadRepository;

@RestController
@RequestMapping("/juez")
public class ModalidadController {

    @Autowired
    private IModalidadRepository modalidadRepository;

    @GetMapping(path = "/listaModalidades")
    public List<Modalidad> getModalidades() {
        return modalidadRepository.getModalidades();
    }

    @GetMapping(path = "/listaModalidades/{id}")
    public Modalidad getModalidadID(@PathVariable int id) {
        return modalidadRepository.getModalidad(id);
    }
}
