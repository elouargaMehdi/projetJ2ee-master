package com.example.projetj2e.dao;

import com.example.projetj2e.bean.CategorieDeLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDeLocalDao  extends JpaRepository<CategorieDeLocal,Long> {
    CategorieDeLocal findByCode(String code);
    int deleteByCode(String code);
}
