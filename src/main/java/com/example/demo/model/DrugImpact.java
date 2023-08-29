package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "drugimpact")
public class DrugImpact {

    @Id
    private String _id;
    private String drugId;
    private String[] directDiseasesId;
    private String[] undirectDiseasesId;

    // Costruttore vuoto
    public DrugImpact() {
    }

    // Metodi getter e setter

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDrugId() {
        return drugId;
    }

    public void setDrugId(String drugId) {
        this.drugId = drugId;
    }

    public String[] getDirectDiseasesId() {
        return directDiseasesId;
    }

    public void setDirectDiseasesId(String[] directDiseasesId) {
        this.directDiseasesId = directDiseasesId;
    }

    public String[] getUndirectDiseasesId() {
        return undirectDiseasesId;
    }

    public void setUndirectDiseasesId(String[] undirectDiseasesId) {
        this.undirectDiseasesId = undirectDiseasesId;
    }
}
