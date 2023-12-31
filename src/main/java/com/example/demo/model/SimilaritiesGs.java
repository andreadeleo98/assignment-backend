package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "similaritiesGs")
public class SimilaritiesGs {

    @Id
    private String _id;
    private String disease1;
    private String diseaseName1;
    private String disease2;
    private String diseaseName2;
    private String[] markers1;
    private String[] markers2;
    private String[] distance0;
    private String[] distance1;
    private double score;
    private String _class;

    // Costruttori

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getDisease1() {
        return disease1;
    }

    public void setDisease1(String disease1) {
        this.disease1 = disease1;
    }

    public String getDiseaseName1() {
        return diseaseName1;
    }

    public void setDiseaseName1(String diseaseName1) {
        this.diseaseName1 = diseaseName1;
    }

    public String getDisease2() {
        return disease2;
    }

    public void setDisease2(String disease2) {
        this.disease2 = disease2;
    }

    public String getDiseaseName2() {
        return diseaseName2;
    }

    public void setDiseaseName2(String diseaseName2) {
        this.diseaseName2 = diseaseName2;
    }

    public String[] getMarkers1() {
        return markers1;
    }

    public void setMarkers1(String[] markers1) {
        this.markers1 = markers1;
    }

    public String[] getMarkers2() {
        return markers2;
    }

    public void setMarkers2(String[] markers2) {
        this.markers2 = markers2;
    }

    public String[] getDistance0() {
        return distance0;
    }

    public void setDistance0(String[] distance0) {
        this.distance0 = distance0;
    }

    public String[] getDistance1() {
        return distance1;
    }

    public void setDistance1(String[] distance1) {
        this.distance1 = distance1;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    // Altri metodi, se necessario
}
