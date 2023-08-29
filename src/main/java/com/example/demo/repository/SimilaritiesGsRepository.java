package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.SimilaritiesGs; // Import the correct Ddi class

public interface SimilaritiesGsRepository extends MongoRepository<SimilaritiesGs, String> {
    // Puoi aggiungere metodi personalizzati per query specifiche, se necessario
}
