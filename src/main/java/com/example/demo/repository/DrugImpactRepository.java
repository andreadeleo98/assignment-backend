package com.example.demo.repository;

import com.example.demo.model.DrugImpact;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrugImpactRepository extends MongoRepository<DrugImpact, String> {

    DrugImpact findByDrugBankId(String drugBankId);

    List<DrugImpact> findByDiseaseInteractor(String diseaseInteractor);
}
