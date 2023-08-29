package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Ddi; // Import the correct Ddi class

public interface DdiRepository extends MongoRepository<Ddi, String> {
    // Puoi aggiungere metodi personalizzati per query specifiche, se necessario
}