package com.example.projetj2e.service.facade;

import com.example.projetj2e.bean.TaxeBoissonTrimestrielle;
import jakarta.transaction.Transactional;

import java.util.List;

public interface TaxeBoissonTrimestrielleService {
     TaxeBoissonTrimestrielle findByReference(String reference) ;
     @Transactional
     int deleteByReference(String reference);
     List<TaxeBoissonTrimestrielle> findAll() ;

    int save(TaxeBoissonTrimestrielle entity);


}
