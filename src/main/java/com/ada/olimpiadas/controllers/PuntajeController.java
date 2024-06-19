package com.ada.olimpiadas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ada.olimpiadas.models.Categoria;
import com.ada.olimpiadas.models.Modalidad;
import com.ada.olimpiadas.models.Participante;
import com.ada.olimpiadas.models.Puntaje;
import com.ada.olimpiadas.repositories.ICategoriaRepository;
import com.ada.olimpiadas.repositories.IModalidadRepository;
import com.ada.olimpiadas.repositories.IPuntajeRepository;

import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/juez")
public class PuntajeController {

    @Autowired
    private IPuntajeRepository puntajeRepository;

 @PostMapping("/puntuar")
    public ResponseEntity<String> puntuar(@RequestBody Puntaje puntaje) {
        try {
            puntajeRepository.guardarPuntaje(puntaje);
            return ResponseEntity.ok("Puntuación guardada exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Error al guardar la puntuación: " + e.getMessage());
        }
    }
}
