package com.example.projetj2e.dao;

import com.example.projetj2e.bean.TauxTaxeTrimestrielle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface TauxTaxeTrimestrielleDao extends JpaRepository<TauxTaxeTrimestrielle,Long> {
    TauxTaxeTrimestrielle findByRef(String reference);
    TauxTaxeTrimestrielle findByCategorieDeLocalCodeAndDateAppMinGreaterThanAndDateAppMaxLessThan(String code, Date date1,Date date2);
    int deleteByRef(String reference);
}
