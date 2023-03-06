package com.example.projetj2e.dao;

import com.example.projetj2e.bean.TaxeBoissonTrimestrielle;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface TaxeBoissonTrimestrielleDao extends JpaRepository<TaxeBoissonTrimestrielle,Long> {
    TaxeBoissonTrimestrielle findByReference(String reference);

    @Transactional
    int deleteByReference(String reference);
}

