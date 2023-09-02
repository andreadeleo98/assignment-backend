package com.example.demo.controller;

import com.example.demo.model.DrugBank;
import com.example.demo.model.AggregatedResult;
import com.example.demo.repository.DrugBankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;


@RestController
@RequestMapping("/api/drugbank")
public class DrugBankController {

    private final DrugBankRepository drugBankRepository;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public DrugBankController(DrugBankRepository drugBankRepository, MongoTemplate mongoTemplate) {
        this.drugBankRepository = drugBankRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @GetMapping
    public List<DrugBank> getAllDrugBanks() {
        return drugBankRepository.findAll();
    }

    @PostMapping
    public DrugBank createDrugBank(@RequestBody DrugBank drugBank) {
        return drugBankRepository.save(drugBank);
    }

    @CrossOrigin
    @GetMapping("/aggregation")
    public List<AggregatedResult> performAggregation(
        @RequestParam(required = false) String searchTerm
    ) {
        List<Criteria> criteriaList = new ArrayList<>();
    
        if (searchTerm != null) {
            // Verifica se il termine di ricerca inizia con "DB" o "db"
            if (searchTerm.matches("(?i)^DB\\d+")) {
                criteriaList.add(Criteria.where("drugId").regex(searchTerm, "i"));
            } else {
                criteriaList.add(Criteria.where("drugName").regex(searchTerm, "i"));
            }
        }

    Criteria finalCriteria = new Criteria();
    if (!criteriaList.isEmpty()) {
        finalCriteria.orOperator(criteriaList.toArray(new Criteria[0]));
    }
        Aggregation aggregation = Aggregation.newAggregation(
            Aggregation.match(finalCriteria),
            Aggregation.lookup("drugimpact", "drugId", "drugId", "drugImpacts"),
            Aggregation.unwind("drugImpacts"),
            Aggregation.unwind("drugImpacts.directDiseasesId"),
            Aggregation.lookup("disease", "drugImpacts.directDiseasesId", "diseaseId", "diseases"),
            Aggregation.unwind("diseases"),
            Aggregation.project()
                .and("drugId").as("drugId")
                .and("drugName").as("drugName")
                .and("diseases.diseaseName").as("diseaseName")
        );
    
        AggregationResults<AggregatedResult> results = mongoTemplate.aggregate(
            aggregation, "drugbank", AggregatedResult.class
        );
    
        return results.getMappedResults();
    }
    

    
    
}
