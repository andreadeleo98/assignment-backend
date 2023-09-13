package com.example.demo.controller;

import com.example.demo.model.Ddi; 
import com.example.demo.repository.DdiRepository; 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/ddi")
public class DdiController {

    @Autowired
    private DdiRepository ddiRepository;

    @GetMapping
    public List<Ddi> getAllDdi() {
        return ddiRepository.findAll();
    }
}
