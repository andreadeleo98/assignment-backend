package com.example.demo.controller;

import com.example.demo.model.Disease;
import com.example.demo.repository.DiseaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseController {

    private final DiseaseRepository diseaseRepository;

    public DiseaseController(DiseaseRepository diseaseRepository) {
        this.diseaseRepository = diseaseRepository;
    }

    @GetMapping
    public List<Disease> getAllDisease() {
        return diseaseRepository.findAll();
    }

    @PostMapping
    public Disease createDisease(@RequestBody Disease disease) {
        return diseaseRepository.save(disease);
    }

}
