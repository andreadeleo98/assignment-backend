package com.example.demo.repository;

import com.example.demo.model.DrugImpact;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DrugImpactRepository extends MongoRepository<DrugImpact, String> {
    // Puoi definire metodi personalizzati qui, se necessario
}
