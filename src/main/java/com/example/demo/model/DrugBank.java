package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "drugBank")
public class DrugBank {

    @Id
    private String _id;
    private String drugBankId;
    private String drugName;
    private List<String> uniprotId;

    // Costruttore vuoto
    public DrugBank() {
    }

    // Metodi getter e setter

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
