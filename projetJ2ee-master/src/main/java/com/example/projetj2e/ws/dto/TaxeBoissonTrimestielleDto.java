package com.example.projetj2e.ws.dto;

import com.example.projetj2e.bean.CategorieDeLocal;
import com.example.projetj2e.bean.Local;
import com.example.projetj2e.bean.Redevable;
import com.example.projetj2e.bean.TauxTaxeTrimestrielle;
import jakarta.persistence.ManyToOne;
import org.springframework.stereotype.Component;

public class TaxeBoissonTrimestielleDto {
    private Long id;
    private String reference;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private CategorieDeLocal categorieDeLocal;
    @ManyToOne

    private TauxTaxeTrimestrielle tauxTaxeTrimestrielle;
    @ManyToOne
    private Local local;
    private int retardMonths;
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

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }

    public CategorieDeLocal getCategorieDeLocal() {
        return categorieDeLocal;
    }

    public void setCategorieDeLocal(CategorieDeLocal categorieDeLocal) {
        this.categorieDeLocal = categorieDeLocal;
    }

    public TauxTaxeTrimestrielle getTauxTaxeTrimestrielle() {
        return tauxTaxeTrimestrielle;
    }

    public void setTauxTaxeTrimestrielle(TauxTaxeTrimestrielle tauxTaxeTrimestrielle) {
        this.tauxTaxeTrimestrielle = tauxTaxeTrimestrielle;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public int getRetardMonths() {
        return retardMonths;
    }

    public void setRetardMonths(int retardMonths) {
        this.retardMonths = retardMonths;
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
