package com.example.demo.repository;

import com.example.demo.model.DrugBank;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrugBankRepository extends MongoRepository<DrugBank, String> {

    DrugBank findByDrugName(String drugName);

    DrugBank findByDrugBankId(String drugBankId);

    List<DrugBank> findByUniprotIdIn(List<String> uniprotIds);
}
