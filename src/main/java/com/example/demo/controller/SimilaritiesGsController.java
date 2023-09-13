package com.example.demo.controller;

import com.example.demo.model.SimilaritiesGs;
import com.example.demo.repository.SimilaritiesGsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/similaritiesGs")
public class SimilaritiesGsController {

    @Autowired
    private SimilaritiesGsRepository similaritiesGsRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/trovaDiseaseName2PerDistance")
    public Map<String, List<String>> trovaDiseaseName2PerDistance(@RequestParam List<String> marcatori) {
        Map<String, List<String>> result = new HashMap<>();

        List<SimilaritiesGs> oggettiConMarcatoriInDistance0 = similaritiesGsRepository.findByDistance0In(marcatori);
        List<SimilaritiesGs> oggettiConMarcatoriInDistance1 = similaritiesGsRepository.findByDistance1In(marcatori);

        List<String> diseaseNamesDistance0 = oggettiConMarcatoriInDistance0.stream()
                .map(SimilaritiesGs::getDiseaseName2)
                .collect(Collectors.toList());

        List<String> diseaseNamesDistance1 = oggettiConMarcatoriInDistance1.stream()
                .map(SimilaritiesGs::getDiseaseName2)
                .collect(Collectors.toList());

        result.put("distance0", diseaseNamesDistance0);
        result.put("distance1", diseaseNamesDistance1);

        return result;
    }

}
