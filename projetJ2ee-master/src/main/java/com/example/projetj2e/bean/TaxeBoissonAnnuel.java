package com.example.projetj2e.bean;

import jakarta.persistence.*;

@Entity
public class TaxeBoissonAnnuel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String reference;
    @ManyToOne
    private Local local;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne

    private CategorieDeLocal categorieLocal;
    private int moisRetard;
    private double montantBase;
    private double montantTotal;
    private double montantRetardPremierMois;
    private double montantRetardAutreMois;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public CategorieDeLocal getCategorieLocal() {
        return categorieLocal;
    }

    public void setCategorieLocal(CategorieDeLocal categorieLocal) {
        this.categorieLocal = categorieLocal;
    }

    public int getMoisRetard() {
        return moisRetard;
    }

    public void setMoisRetard(int moisRetard) {
        this.moisRetard = moisRetard;
    }

    public double getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(double montantBase) {
        this.montantBase = montantBase;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public double getMontantRetardPremierMois() {
        return montantRetardPremierMois;
    }

    public void setMontantRetardPremierMois(double montantRetardPremierMois) {
        this.montantRetardPremierMois = montantRetardPremierMois;
    }

    public double getMontantRetardAutreMois() {
        return montantRetardAutreMois;
    }

    public void setMontantRetardAutreMois(double montantRetardAutreMois) {
        this.montantRetardAutreMois = montantRetardAutreMois;
    }

}
