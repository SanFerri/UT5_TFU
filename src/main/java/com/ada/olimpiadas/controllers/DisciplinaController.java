package com.ada.olimpiadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Categoria;
import com.ada.olimpiadas.models.Disciplina;
import com.ada.olimpiadas.models.Modalidad;
import com.ada.olimpiadas.repositories.ICategoriaRepository;
import com.ada.olimpiadas.repositories.IDisciplinaRepository;
import com.ada.olimpiadas.repositories.IModalidadRepository;

@RestController
@RequestMapping("/juez")
public class DisciplinaController {
    @Autowired
    private IDisciplinaRepository disciplinaRepository;

    @GetMapping(path = "/listaDisciplinas")
    public List<Disciplina> getDisciplinas() {
        return disciplinaRepository.getDisciplinas();
    }

    @GetMapping(path = "/listaDisciplinas/{id}")
    public Disciplina getDisciplinaID(@PathVariable int id) {
        return disciplinaRepository.getDisciplina(id);
    }
}
