package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "dgi")
public class Dgi {

    @Id
    private String _id;
    private String diseaseInteractor;
    private String proteinInteractor;
    private String[] source;
    private Score score;
    private Reference[] rawReferences;
    private String _class;

    // Getter e setter per _id
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    // Getter e setter per diseaseInteractor
    public String getDiseaseInteractor() {
        return diseaseInteractor;
    }

    public void setDiseaseInteractor(String diseaseInteractor) {
        this.diseaseInteractor = diseaseInteractor;
    }

    // Getter e setter per proteinInteractor
    public String getProteinInteractor() {
        return proteinInteractor;
    }

    public void setProteinInteractor(String proteinInteractor) {
        this.proteinInteractor = proteinInteractor;
    }

    // Getter e setter per source
    public String[] getSource() {
        return source;
    }

    public void setSource(String[] source) {
        this.source = source;
    }

    // Getter e setter per score
    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    // Getter e setter per rawReferences
    public Reference[] getRawReferences() {
        return rawReferences;
    }

    public void setRawReferences(Reference[] rawReferences) {
        this.rawReferences = rawReferences;
    }

    // Getter e setter per _class
    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public class Score {
    private double JACCARD_VARIANT;
    private double JACCARD_GENE;

    public double getJACCARD_VARIANT() {
        return JACCARD_VARIANT;
    }

    public void setJACCARD_VARIANT(double jaccardVariant) {
        JACCARD_VARIANT = jaccardVariant;
    }

    public double getJACCARD_GENE() {
        return JACCARD_GENE;
    }

    public void setJACCARD_GENE(double jaccardGene) {
        JACCARD_GENE = jaccardGene;
    }

    // ... altri campi, getter, setter
    }

    public class Reference {
        private ParsedDatabase parsedDatabase;

        public ParsedDatabase getParsedDatabase() {
            return parsedDatabase;
        }

        public void setParsedDatabase(ParsedDatabase parsedDatabase) {
            this.parsedDatabase = parsedDatabase;
        }

        // ... altri campi, getter, setter
    }

    public class ParsedDatabase {
        private String parsedDatabase;

        public String getParsedDatabase() {
            return parsedDatabase;
        }

        public void setParsedDatabase(String parsedDatabase) {
            this.parsedDatabase = parsedDatabase;
        }

        // ... altri campi, getter, setter
    }
}
