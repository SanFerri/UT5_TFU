package com.ada.olimpiadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Disciplina;
import com.ada.olimpiadas.repositories.IDisciplinaRepository;

@RestController
@RequestMapping("/disciplina")
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
