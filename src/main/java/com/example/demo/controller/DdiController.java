package com.example.demo.controller;

import com.example.demo.model.Ddi; 
import com.example.demo.repository.DdiRepository; 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Map; 

@RestController
@RequestMapping("/api/ddi")
public class DdiController {

    @Autowired
    private DdiRepository ddiRepository;

    @GetMapping
    public List<Ddi> getAllDdi() {
        return ddiRepository.findAll();
    }

    @PostMapping
    public Ddi createDdi(@RequestBody Ddi ddi) {
        return ddiRepository.save(ddi);
    }

    @GetMapping("/first")
    public Ddi getFirstDdi() {
        PageRequest pageRequest = PageRequest.of(0, 1); // Page 0, Size 1
        List<Ddi> firstDdi = ddiRepository.findAll(pageRequest).getContent();

        if (!firstDdi.isEmpty()) {
            return firstDdi.get(0);
        } else {
            throw new NoSuchElementException("No elements found in the collection.");
        }
    }

    @GetMapping("/count")
    public ResponseEntity<?> getDdiCount() {
        long count = ddiRepository.count();
        return ResponseEntity.ok(Map.of("count", count));
    }

    @GetMapping("/test")
    public List<Ddi> testEndpoint() {
        return List.of(); // Return an empty list
    }
}
