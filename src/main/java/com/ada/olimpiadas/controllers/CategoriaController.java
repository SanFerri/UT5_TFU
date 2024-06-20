package com.ada.olimpiadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Categoria;
import com.ada.olimpiadas.repositories.ICategoriaRepository;



@RestController
@RequestMapping("/juez")
public class CategoriaController {

    @Autowired
    private ICategoriaRepository categoriaRepository;

    @GetMapping(path = "/listaCategorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.getCategorias();
    }

    @GetMapping(path = "/listaCategorias/{id}")
    public Categoria getCategoriaID(@PathVariable int id) {
        return categoriaRepository.getCategoria(id);
    }
    
}
