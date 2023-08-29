package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.Dgi;

public interface DgiRepository extends MongoRepository<Dgi, String> {
    // Puoi aggiungere metodi personalizzati per query specifiche, se necessario
}