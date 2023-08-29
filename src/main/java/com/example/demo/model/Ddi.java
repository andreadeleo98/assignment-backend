package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ddi")
public class Ddi {

    @Id
    private String _id;
    private String disease1;
    private String disease2;
    private Score score;
    private String[] source;
    private Reference[] rawReferences;
    private String _class;

    // ... altri campi

    public class Score {
        private double JACCARD_VARIANT;
        private double JACCARD_GENE;

        // ... altri campi, getter, setter
        public double getJACCARD_VARIANT() {
            return JACCARD_VARIANT;
        }

        public void setJACCARD_VARIANT(double jACCARD_VARIANT) {
            JACCARD_VARIANT = jACCARD_VARIANT;
        }

        public double getJACCARD_GENE() {
            return JACCARD_GENE;
        }

        public void setJACCARD_GENE(double jACCARD_GENE) {
            JACCARD_GENE = jACCARD_GENE;
        }
    }

    public class Reference {
        private ParsedDatabase parsedDatabase;

        // ... altri campi, getter, setter
        public ParsedDatabase getParsedDatabase() {
            return parsedDatabase;
        }

        public void setParsedDatabase(ParsedDatabase parsedDatabase) {
            this.parsedDatabase = parsedDatabase;
        }
    }

    public class ParsedDatabase {
        private String parsedDatabase;

        // ... altri campi, getter, setter
        public String getParsedDatabase() {
            return parsedDatabase;
        }

        public void setParsedDatabase(String parsedDatabase) {
            this.parsedDatabase = parsedDatabase;
        }
    }

    // Getter e setter per gli altri campi
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

    public String getDisease2() {
        return disease2;
    }

    public void setDisease2(String disease2) {
        this.disease2 = disease2;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
    }

    public String[] getSource() {
        return source;
    }

    public void setSource(String[] source) {
        this.source = source;
    }

    public Reference[] getRawReferences() {
        return rawReferences;
    }

    public void setRawReferences(Reference[] rawReferences) {
        this.rawReferences = rawReferences;
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }
}
