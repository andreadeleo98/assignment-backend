package com.example.demo.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ppi")
public class Ppi {

    @Id
    private String _id;
    private String firstInteractorId;
    private String secondInteractorId;
    private Experiment[] proteinExperiments;
    private Score score;
    private Reference[] rawReferences;
    private String _class;

    // ... altri campi, costruttori

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getFirstInteractorId() {
        return firstInteractorId;
    }

    public void setFirstInteractorId(String firstInteractorId) {
        this.firstInteractorId = firstInteractorId;
    }

    public String getSecondInteractorId() {
        return secondInteractorId;
    }

    public void setSecondInteractorId(String secondInteractorId) {
        this.secondInteractorId = secondInteractorId;
    }

    public Experiment[] getProteinExperiments() {
        return proteinExperiments;
    }

    public void setProteinExperiments(Experiment[] proteinExperiments) {
        this.proteinExperiments = proteinExperiments;
    }

    public Score getScore() {
        return score;
    }

    public void setScore(Score score) {
        this.score = score;
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

    public class Experiment {

        // ... altri campi, getter, setter
    }

    public class Score {
        private double intactMiscore;
        
        // ... altri campi, getter, setter
    }

    public class Reference {
        private String aliasInteractorA;
        private String aliasInteractorB;
        private ParsedDatabase parsedDatabase;
        
        // ... altri campi, getter, setter
    }

    public class ParsedDatabase {
        private String parsedDatabase;
        
        // ... altri campi, getter, setter
    }
}
