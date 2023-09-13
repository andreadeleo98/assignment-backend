package com.example.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.demo.model.AggregatedResult;

public interface AggregatedResultRepository extends MongoRepository<AggregatedResult, String> {
}
