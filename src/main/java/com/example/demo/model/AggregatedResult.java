package com.example.demo.model;

import java.util.List;

public class AggregatedResult {

    private String drugBankId;
    private String drugName;
    private List<String> uniprotId;

    public AggregatedResult() {
    }

    public String getDrugBankId() {
        return drugBankId;
    }

    public void setDrugBankId(String drugBankId) {
        this.drugBankId = drugBankId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public List<String> getUniprotId() {
        return uniprotId;
    }

    public void setUniprotId(List<String> uniprotId) {
        this.uniprotId = uniprotId;
    }
}
