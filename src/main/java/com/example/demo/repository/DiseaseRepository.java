package com.example.demo.repository;

import com.example.demo.model.Disease;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DiseaseRepository extends MongoRepository<Disease, String> {

        Disease findBydiseaseName(String diseaseName);

        Disease findByDiseaseId(String diseaseId);

        Disease findByDiseaseName(String diseaseName);

}
