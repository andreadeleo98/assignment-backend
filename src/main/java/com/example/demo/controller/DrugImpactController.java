package com.example.demo.controller;

import com.example.demo.model.DrugImpact;
import com.example.demo.repository.DrugImpactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/drugImpact")
public class DrugImpactController {

    @Autowired
    private DrugImpactRepository drugImpactRepository;

    @GetMapping
    public List<DrugImpact> getAllDrugImpacts() {
        return drugImpactRepository.findAll();
    }

    // Ricerca per drugBankId
    @GetMapping("/byDrugImpactId/{drugBankId}")
    public ResponseEntity<DrugImpact> findByDrugBankId(@PathVariable String drugBankId) {
        DrugImpact drugImpact = drugImpactRepository.findByDrugBankId(drugBankId);
        if (drugImpact != null) {
            return ResponseEntity.ok(drugImpact);
        } else {
            return ResponseEntity.notFound().build();
        }
    }    

    // Ricerca per diseaseInteractor
@GetMapping("/byDiseaseInteractor/{diseaseInteractor}")
public ResponseEntity<List<String>> findByDiseaseInteractor(@PathVariable String diseaseInteractor) {
    List<DrugImpact> drugImpacts = drugImpactRepository.findByDiseaseInteractor(diseaseInteractor);
    if (!drugImpacts.isEmpty()) {
        // Estrai gli drugBankId dalla lista di oggetti DrugImpact
        List<String> result = new ArrayList<>();
        for (DrugImpact drugImpact : drugImpacts) {
            result.add(drugImpact.getDrugBankId());
        }
        return ResponseEntity.ok(result);
    } else {
        return ResponseEntity.notFound().build();
    }
}

}
