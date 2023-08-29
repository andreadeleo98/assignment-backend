package com.example.demo.model;

public class AggregatedResult {
    private String drugId; // Aggiunto il campo drugId
    private String drugName;
    private String diseaseName;

    // Costruttore vuoto necessario per la deserializzazione da MongoDB
    public AggregatedResult() {}

    // Costruttore con i campi necessari
    public AggregatedResult(String drugId, String drugName, String diseaseName) {
        this.drugId = drugId;
        this.drugName = drugName;
        this.diseaseName = diseaseName;
    }

    // Getter e setter per il campo drugId
    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    // Getter e setter per il campo drugName
    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    // Getter e setter per il campo diseaseName
    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }
}
