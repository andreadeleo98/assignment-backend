package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "drugImpact")
public class DrugImpact {

    @Id
    private String _id;
    private String drugBankId;
    private List<String> diseaseInteractor;

    public DrugImpact() {
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDrugBankId() {
        return drugBankId;
    }

    public void setDrugBankId(String drugBankId) {
        this.drugBankId = drugBankId;
    }

    public List<String> getDiseaseInteractor() {
        return diseaseInteractor;
    }

    public void setDiseaseInteractor(List<String> diseaseInteractor) {
        this.diseaseInteractor = diseaseInteractor;
    }
}
