package com.example.demo.controller;

import com.example.demo.model.Dgi;
import com.example.demo.repository.DgiRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/dgi")
public class DgiController {

    @Autowired
    private DgiRepository dgiRepository;

    @GetMapping
    public List<Dgi> getAllDgi() {
        return dgiRepository.findAll();
    }

}
