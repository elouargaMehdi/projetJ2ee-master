package com.example.projetj2e.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class TauxTaxeAnnuel {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    
    private double pourcentageCasRetard;
    private double premierMoisRetard;
    private double autreMoisRetard;
    private Date dateAppMin;
    private Date dateAppMax;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getPourcentageCasRetard() {
        return pourcentageCasRetard;
    }

    public void setPourcentageCasRetard(double pourcentageCasRetard) {
        this.pourcentageCasRetard = pourcentageCasRetard;
    }

    public double getPremierMoisRetard() {
        return premierMoisRetard;
    }

    public void setPremierMoisRetard(double premierMoisRetard) {
        this.premierMoisRetard = premierMoisRetard;
    }

    public double getAutreMoisRetard() {
        return autreMoisRetard;
    }

    public void setAutreMoisRetard(double autreMoisRetard) {
        this.autreMoisRetard = autreMoisRetard;
    }

    public Date getDateAppMin() {
        return dateAppMin;
    }

    public void setDateAppMin(Date dateAppMin) {
        this.dateAppMin = dateAppMin;
    }

    public Date getDateAppMax() {
        return dateAppMax;
    }

    public void setDateAppMax(Date dateAppMax) {
        this.dateAppMax = dateAppMax;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }
}
