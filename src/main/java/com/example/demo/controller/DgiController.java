package com.example.demo.controller;

import com.example.demo.model.Dgi;
import com.example.demo.repository.DgiRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Map; 

@RestController
@RequestMapping("/api/dgi")
public class DgiController {

    @Autowired
    private DgiRepository dgiRepository;

    @GetMapping
    public List<Dgi> getAllDgi() {
        return dgiRepository.findAll();
    }

    @PostMapping
    public Dgi createDgi(@RequestBody Dgi dgi) {
        return dgiRepository.save(dgi);
    }

    @GetMapping("/first")
    public Dgi getFirstDgi() {
        PageRequest pageRequest = PageRequest.of(0, 1); // Page 0, Size 1
        List<Dgi> firstDgi = dgiRepository.findAll(pageRequest).getContent();

        if (!firstDgi.isEmpty()) {
            return firstDgi.get(0);
        } else {
            throw new NoSuchElementException("No elements found in the collection.");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> getDgiCount() {
        long count = dgiRepository.count();
        return ResponseEntity.ok(Map.of("count", count));
    }

    @GetMapping("/test")
    public List<Dgi> testEndpoint() {
        return List.of(); // Return an empty list
    }
}
