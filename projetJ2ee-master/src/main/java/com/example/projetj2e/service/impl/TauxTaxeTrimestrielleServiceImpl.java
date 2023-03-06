package com.example.projetj2e.service.impl;

import com.example.projetj2e.bean.TauxTaxeTrimestrielle;
import com.example.projetj2e.dao.TauxTaxeTrimestrielleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TauxTaxeTrimestrielleServiceImpl {
    @Autowired
    private TauxTaxeTrimestrielleDao tauxTaxeTrimestrielleDao;

    public TauxTaxeTrimestrielle findByRef(String reference) {
        return tauxTaxeTrimestrielleDao.findByRef(reference);
    }

    public int deleteByRef(String reference) {
        return tauxTaxeTrimestrielleDao.deleteByRef(reference);
    }

    public List<TauxTaxeTrimestrielle> findAll() {
        return tauxTaxeTrimestrielleDao.findAll();
    }

    public TauxTaxeTrimestrielle findByCategorieDeLocalCodeAndDateAppMinGreaterThanAndDateAppMaxLessThan(String code, Date date1,Date date2) {
        return tauxTaxeTrimestrielleDao.findByCategorieDeLocalCodeAndDateAppMinGreaterThanAndDateAppMaxLessThan(code, date1,date2);
    }

    public int save(TauxTaxeTrimestrielle entity) {
        if(findByRef(entity.getRef())!=null){
            return -1;//déja exist
        }else if(categorieDeLocalService.findByCode(entity.getCategorieDeLocal().getCode())==null){
            return -2;//categorie de local n'exist pas
        }else if(entity.getPourcentage()<0){
            return -3;//pourcentage par chiffre d'affaire n'egative
        }
        else{
            tauxTaxeTrimestrielleDao.save(entity);
            return 1;
        }

    }
    @Autowired
    private CategorieDeLocalServiceImpl categorieDeLocalService;
}
