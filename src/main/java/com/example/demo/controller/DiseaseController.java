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

    @GetMapping("/byDiseaseName/{diseaseName}")
        public Disease findBydiseaseName(@PathVariable String diseaseName) {
            return diseaseRepository.findBydiseaseName(diseaseName);
    }

    @GetMapping("/byDiseaseId/{diseaseId}")
        public Disease findByDiseaseId(@PathVariable String diseaseId) {
            return diseaseRepository.findByDiseaseId(diseaseId);
    }

}
