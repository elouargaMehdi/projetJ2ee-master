package com.example.projetj2e.dao;


import com.example.projetj2e.bean.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface LocalDao extends JpaRepository<Local,Long> {
    List<Local> findByRedevableCin(String cin);
    Local findByReference(String reference);
    int deleteByRedevableCin(String cin);
}
