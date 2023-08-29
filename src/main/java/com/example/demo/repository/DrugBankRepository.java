package com.example.demo.repository;

import com.example.demo.model.DrugBank;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrugBankRepository extends MongoRepository<DrugBank, String> {
    // Puoi definire metodi personalizzati qui, se necessario
}
