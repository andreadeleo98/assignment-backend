package com.example.demo.controller;

import com.example.demo.model.DrugImpact;
import com.example.demo.repository.DrugImpactRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/drugimpact")
public class DrugImpactController {

    private final DrugImpactRepository drugImpactRepository;

    public DrugImpactController(DrugImpactRepository drugImpactRepository) {
        this.drugImpactRepository = drugImpactRepository;
    }

    @GetMapping
    public List<DrugImpact> getAllDrugImpacts() {
        return drugImpactRepository.findAll();
    }

    @PostMapping
    public DrugImpact createDrugImpact(@RequestBody DrugImpact drugImpact) {
        return drugImpactRepository.save(drugImpact);
    }

}
