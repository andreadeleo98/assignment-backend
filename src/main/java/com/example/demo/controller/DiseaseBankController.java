package com.example.demo.controller;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DiseaseBank;
import com.example.demo.repository.DiseaseBankRepository;

import java.util.regex.Pattern;

@RestController
public class DiseaseBankController {

    private DiseaseBankRepository diseaseBankRepository;
    private MongoTemplate mongoTemplate;

    public DiseaseBankController(DiseaseBankRepository diseaseBankRepository, MongoTemplate mongoTemplate) {
        this.diseaseBankRepository = diseaseBankRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping("/api/diseaseBank/byDisease")
    public ResponseEntity<DiseaseBank> getDiseaseInfo(@RequestParam(required = false) String diseaseIdentifier) {
        if (diseaseIdentifier != null) {
            DiseaseBank disease;

            // Verifica se il parametro fornito è un ID di malattia che inizia con "C" seguito da solo numeri
            if (Pattern.matches("^C\\d+$", diseaseIdentifier)) {
                disease = diseaseBankRepository.findByDiseaseId(diseaseIdentifier);
            } else {
                Criteria regexCriteria = Criteria.where("diseaseName").regex("^" + Pattern.quote(diseaseIdentifier), "i");
                Query query = new Query(regexCriteria);
                disease = mongoTemplate.findOne(query, DiseaseBank.class);
            }

            if (disease != null) {
                return ResponseEntity.ok(disease);
            }
        }

        return ResponseEntity.notFound().build();
    }
}
