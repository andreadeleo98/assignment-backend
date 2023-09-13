package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DrugBank;
import com.example.demo.repository.DrugBankRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/drugBank")
public class DrugBankController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Autowired
    private DrugBankRepository drugBankRepository;

    @GetMapping
    public List<DrugBank> getAllDrugBanks() {
        return drugBankRepository.findAll();
    }

    @GetMapping("/byDrugName/{drugName}")
    public DrugBank findByDrugName(@PathVariable String drugName) {
        return drugBankRepository.findByDrugName(drugName);
    }

    @GetMapping("/byDrugBankId/{drugBankId}")
    public DrugBank findByDrugBankId(@PathVariable String drugBankId) {
        return drugBankRepository.findByDrugBankId(drugBankId);
    }

    @GetMapping("/byUniprotIds")
    public List<String> findDrugNamesByUniprotIds(@RequestParam List<String> uniprotIds) {

        // Crea una query che cerca i documenti con almeno uno degli uniprotId nella lista
        Query query = new Query(Criteria.where("uniprotId").in(uniprotIds));
    
        // Esegui la query nel repository e ottieni i risultati
        List<DrugBank> drugBanks = mongoTemplate.find(query, DrugBank.class);
    
        // Estrai i drugName dai risultati
        List<String> drugNames = drugBanks.stream()
                .map(DrugBank::getDrugName)
                .collect(Collectors.toList());
    
        return drugNames;
    }
    
}
