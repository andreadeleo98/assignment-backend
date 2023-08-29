package com.example.demo.controller;

import com.example.demo.model.Ppi;
import com.example.demo.repository.PpiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ppi")
public class PpiController {

    @Autowired
    private PpiRepository ppiRepository;

    @GetMapping
    public List<Ppi> getAllPpi() {
        return ppiRepository.findAll();
    }

    @PostMapping
    public Ppi createPpi(@RequestBody Ppi ppi) {
        return ppiRepository.save(ppi);
    }

    // Aggiungi altri metodi per le operazioni di lettura, aggiornamento ed eliminazione
}
