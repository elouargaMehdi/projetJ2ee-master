package com.example.projetj2e.service.impl;

import com.example.projetj2e.bean.Redevable;
import com.example.projetj2e.dao.RedevableDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RedevableServiceImpl {
    @Autowired
    private RedevableDao redevableDao;

    @Autowired
    private LocalServiceImpl localService;


    public Redevable findByCin(String cin) {
              return  redevableDao.findByCin(cin);
    }
    @Transactional
    public  int deleteByCin(String cin){
        int resultLocal=localService.deleteByRedevableCin(cin);
         int resultatRedevable=redevableDao.deleteByCin(cin);
         return resultatRedevable+resultLocal;

    }
    public int save(Redevable redevable) {
        if (findByCin(redevable.getCin()) != null) {
            return -1;
        }
        else {
            redevableDao.save(redevable);
            return 1;
        }

    }
}
