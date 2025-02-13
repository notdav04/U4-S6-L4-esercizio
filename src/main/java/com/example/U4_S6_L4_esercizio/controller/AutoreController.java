package com.example.U4_S6_L4_esercizio.controller;

import com.example.U4_S6_L4_esercizio.dto.AutoreDTO;
import com.example.U4_S6_L4_esercizio.model.Autore;
import com.example.U4_S6_L4_esercizio.service.AutoreService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/autore")
public class AutoreController {
    @Autowired
    AutoreService autoreService;

    //ok
    /*@GetMapping
    public List<Autore> getAllAutori() {
        return autoreService.getAllAutori();
    }*/
    //esempio getAll con paginazione
    @GetMapping
    public Page<Autore> getAutori(@RequestParam(defaultValue = "0") int page, @RequestParam(defaultValue = "10") int size, @RequestParam(defaultValue = "id") String sortBy) {
        return autoreService.getAutori(page, size, sortBy);
    }

    //ok
    @GetMapping("/{id}")
    public ResponseEntity<Autore> ricercaById(@PathVariable Long id) {
        Optional<Autore> autoreRicercato = autoreService.getAutoreById(id);
        if (autoreRicercato.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(autoreRicercato.get(), HttpStatus.OK);
        }
    }

    //ok
    @PostMapping
    public String nuovoAutore(@RequestBody AutoreDTO nuovoAutore) {
        Long idGenerato = autoreService.addAutore(nuovoAutore);
        return "Autore inserito in DB con id: " + idGenerato;
    }

    //ok
    @PutMapping("/{id}")
    public ResponseEntity<Autore> modificaAutoreById(@PathVariable Long id, @RequestBody AutoreDTO autoreDTO) {
        Optional<Autore> autoreRicercato = autoreService.getAutoreById(id);
        if (autoreRicercato.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        } else {
            Autore autoreEsistente = autoreRicercato.get();
            autoreEsistente.setNome(autoreDTO.getNome());
            autoreEsistente.setCognome(autoreDTO.getCognome());
            autoreEsistente.setEmail(autoreDTO.getEmail());
            autoreEsistente.setDataDiNascita(autoreDTO.getDataDiNascita());
            Autore autoreAggiornato = autoreService.addAutore2(autoreEsistente);
            return new ResponseEntity<>(autoreAggiornato, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{id}")
    public String deleteAutoreById(@PathVariable int id) {
        autoreService.deleteAutoreById(id);
        return "Autore con id " + id + " eliminato con successo";
    }

}