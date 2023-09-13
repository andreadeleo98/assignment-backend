package com.example.demo.controller;

import com.example.demo.model.AggregatedResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.data.mongodb.core.query.Criteria;
import java.util.List;
import java.util.regex.Pattern;

@RestController
@RequestMapping("/api/aggregatedResult")
public class AggregatedResultController {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public AggregatedResultController(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/searchTerm")
    public List<AggregatedResult> getAggregatedResults(
        @RequestParam(value = "diseaseParam", required = false) String diseaseParam
    ) {
        Aggregation aggregation;

        if (diseaseParam != null && !diseaseParam.isEmpty()) {
            // Verifica se il parametro fornito è un ID di malattia che inizia con "C" seguito da solo numeri
            if (Pattern.matches("^C\\d+$", diseaseParam)) {
                aggregation = Aggregation.newAggregation(
                    Aggregation.match(Criteria.where("diseaseId").is(diseaseParam)),
                    Aggregation.lookup("drugImpact", "diseaseId", "diseaseInteractor", "impactedDrugs"),
                    Aggregation.unwind("impactedDrugs"),
                    Aggregation.lookup("drugBank", "impactedDrugs.drugBankId", "drugBankId", "drugDetails"),
                    Aggregation.unwind("drugDetails"),
                    Aggregation.project()
                        .andExclude("_id")
                        .andInclude("drugDetails.drugBankId")
                        .andInclude("drugDetails.drugName")
                        .andInclude("drugDetails.uniprotId")
                );
            } else {
                // Il parametro fornito è un nome di malattia (insensibile alle maiuscole e minuscole)
                Criteria regexCriteria = Criteria.where("diseaseName").regex("^" + Pattern.quote(diseaseParam), "i");
                aggregation = Aggregation.newAggregation(
                    Aggregation.match(regexCriteria),
                    Aggregation.lookup("drugImpact", "diseaseId", "diseaseInteractor", "impactedDrugs"),
                    Aggregation.unwind("impactedDrugs"),
                    Aggregation.lookup("drugBank", "impactedDrugs.drugBankId", "drugBankId", "drugDetails"),
                    Aggregation.unwind("drugDetails"),
                    Aggregation.project()
                        .andExclude("_id")
                        .andInclude("drugDetails.drugBankId")
                        .andInclude("drugDetails.drugName")
                        .andInclude("drugDetails.uniprotId")
                );
            }
        } else {
            aggregation = Aggregation.newAggregation(
            );
        }

        AggregationResults<AggregatedResult> results = mongoTemplate.aggregate(aggregation, "disease", AggregatedResult.class);
        return results.getMappedResults();
    }
}
