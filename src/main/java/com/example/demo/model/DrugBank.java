package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drugbank")
public class DrugBank {

    @Id
    private String _id;
    private String drugBankId;
    private String drugBankName;

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

    public void setDrugBankId(String DrugBankId) {
        this.drugBankId = DrugBankId;
    }

    public String getDrugBankName() {
        return drugBankName;
    }

    public void setDrugBankName(String DrugBankName) {
        this.drugBankName = DrugBankName;
    }
}
