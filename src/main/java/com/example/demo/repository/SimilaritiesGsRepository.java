package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.SimilaritiesGs; // Import the correct Ddi class

public interface SimilaritiesGsRepository extends MongoRepository<SimilaritiesGs, String> {

        List<SimilaritiesGs> findByDistance0In(List<String> marcatori);

        List<SimilaritiesGs> findByDistance1In(List<String> marcatori);

}
