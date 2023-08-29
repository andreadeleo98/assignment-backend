package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Ppi; // Import the correct Ddi class

public interface PpiRepository extends MongoRepository<Ppi, String> {
    // Puoi aggiungere metodi personalizzati per query specifiche, se necessario
}
