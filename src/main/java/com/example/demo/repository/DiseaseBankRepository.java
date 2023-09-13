package com.example.demo.repository;

import com.example.demo.model.DiseaseBank;


import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiseaseBankRepository extends MongoRepository<DiseaseBank, String> {

    DiseaseBank findByDiseaseId(String diseaseId);
    DiseaseBank findByDiseaseName(String diseaseName);
}
