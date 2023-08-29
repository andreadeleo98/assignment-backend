package com.example.demo.controller;

import com.example.demo.model.SimilaritiesGs;
import com.example.demo.repository.SimilaritiesGsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/similaritiesGs")
public class SimilaritiesGsController {

    @Autowired
    private SimilaritiesGsRepository similaritiesGsRepository;

    @GetMapping
    public List<SimilaritiesGs> getAllSimilaritiesGs() {
        return similaritiesGsRepository.findAll();
    }

    @PostMapping
    public SimilaritiesGs createSimilaritiesGs(@RequestBody SimilaritiesGs similaritiesGs) {
        return similaritiesGsRepository.save(similaritiesGs);
    }

    // Aggiungi altri metodi per le operazioni di lettura, aggiornamento ed eliminazione
}
