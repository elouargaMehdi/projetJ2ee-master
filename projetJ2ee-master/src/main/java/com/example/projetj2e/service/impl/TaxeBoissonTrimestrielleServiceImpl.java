package com.example.projetj2e.service.impl;

import com.example.projetj2e.bean.Local;
import com.example.projetj2e.bean.TaxeBoissonTrimestrielle;
import com.example.projetj2e.dao.TaxeBoissonTrimestrielleDao;
import com.example.projetj2e.service.facade.TaxeBoissonTrimestrielleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.crypto.Data;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TaxeBoissonTrimestrielleServiceImpl implements TaxeBoissonTrimestrielleService {


    public TaxeBoissonTrimestrielle findByReference(String reference) {
        return taxeBoissonTrimestrielleDao.findByReference(reference);
    }
@Transactional
    public int deleteByReference(String reference) {
        return taxeBoissonTrimestrielleDao.deleteByReference(reference);
    }

    public List<TaxeBoissonTrimestrielle> findAll() {
        return taxeBoissonTrimestrielleDao.findAll();
    }

    public int save(TaxeBoissonTrimestrielle entity) {
        if(findByReference(entity.getReference())!=null){
            return -1;//deja exist
        }else if(redevableService.findByCin(entity.getRedevable().getCin())==null){
               return -2;//redevable n'exist pas
        }
        else if(localService.findByReference(entity.getLocal().getRef())==null){
            return -3;//local n'exist pas
        }else if(entity.getChifrreAffaire()<=0) {
            return -4;//chiffre d'affairre null ou negative
        }
        long diffInMilliseconds = Math.abs((new Date()).getTime() - entity.getLocal().getDateAjoutDeLocal().getTime());
        long diffInDays = TimeUnit.DAYS.convert(diffInMilliseconds, TimeUnit.MILLISECONDS);
        if(diffInDays<=90){
            //you come before time
            return -6;
        }
        else{
            Local local = localService.findByReference(entity.getLocal().getRef());
            if(local.getDernierDatePayTrimestriel()==null){
                //first taxeTrimestrielle
                Calendar cal0 = Calendar.getInstance();
                cal0.setTime(local.getDateAjoutDeLocal());
                cal0.add(Calendar.MONTH,3);
                local.setDernierDatePayTrimestriel(cal0.getTime());
            }
            if(entity.getLocal().getCategorieDeLocal().getCode()!=entity.getCategorieDeLocal().getCode()) {
            //si le categorie de local est change en doit fait le mise ajour de categorie
            local.setCategorieDeLocal(entity.getCategorieDeLocal());
            localService.update(local);
            }
            //si le cetegorie change ou le date min et max  chnage ==> taux change
            Date dateActuelle = new Date();
            entity.setTauxTaxeTrimestrielle(tauxTaxeTrimestrielleService.findByCategorieDeLocalCodeAndDateAppMinGreaterThanAndDateAppMaxLessThan(entity.getCategorieDeLocal().getCode(),dateActuelle,dateActuelle));
            //traitement
            //1 - calcul montant de base
            double chiffreAffaire=entity.getChifrreAffaire();
            double pourcentage=entity.getTauxTaxeTrimestrielle().getPourcentage();
            double montantBase= chiffreAffaire*pourcentage/100;
            //2 - calcul de retard
            Date dernierPayementTri=entity.getLocal().getDernierDatePayTrimestriel();
            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(dernierPayementTri);
            cal1.add(Calendar.MONTH,3);//dernier date de payment n'inclu pas le retard c'est la date parfait
            Date dateMinRetard = cal1.getTime();
            Calendar cal2 = Calendar.getInstance();
            cal2.setTime(dernierPayementTri);
            cal2.add(Calendar.MONTH,4);//dernier date de payment n'inclu pas le retard c'est la date parfait
            Date dateMaxRetard = cal2.getTime();

            long diffInMillies1 = dateActuelle.getTime() - dateMinRetard.getTime(); // calculate the difference in milliseconds
            long diffInDays1 = TimeUnit.DAYS.convert(diffInMillies1, TimeUnit.MILLISECONDS); // convert the difference in milliseconds to days
            long diffInMillies2 = dateMaxRetard.getTime() - dateActuelle.getTime(); // calculate the difference in milliseconds
            long diffInDays2 = TimeUnit.DAYS.convert(diffInMillies2, TimeUnit.MILLISECONDS); // convert the difference in milliseconds to days
            //inisialize montant retard avec 0
            double montantRetard=0;
            int retardMonths=0;
            double mtpremiermois=0;
            double mtautremois=0;
            double mtretardTotal=0;
            if(diffInDays1<0){
                //attende a la fin de trimestre pour payer le taxe
                return -5;

            }else if(diffInDays2>0){
                //vous avez en retard
                long oneMonth= Duration.ofDays(30).toMillis();
                long diffInMilliers3=dateActuelle.getTime()-dernierPayementTri.getTime()+oneMonth;
                long diffInDays3 = TimeUnit.DAYS.convert(diffInMilliers3,TimeUnit.MILLISECONDS);
                double retard=diffInDays3/30;
                 retardMonths=(int)Math.floor(retard);
                 mtpremiermois=chiffreAffaire*entity.getTauxTaxeTrimestrielle().getPourcentageRetardPremierMois()/100;//calcule mtretard de premier mois
                 mtautremois=(retardMonths-1)*chiffreAffaire*entity.getTauxTaxeTrimestrielle().getPourcentageRetardAutreMois()/100;//calcule de montant retard de les autre mois
                 mtretardTotal=mtpremiermois+mtautremois;

            }
            //saving process
            entity.setMontantBase(montantBase);
            entity.setRetardMonths(retardMonths);
            entity.setMontantRetardPremierMois(mtpremiermois);
            entity.setMontantRetardAutreMois(mtautremois);
            entity.setMontantTotal(montantBase+mtretardTotal);
            //update dernierpaytrimestirelle in   local
            // derpayementTrimestrielle=derpayementTrimestrielle+3months
            Calendar cal3 = Calendar.getInstance();
            cal3.setTime(entity.getLocal().getDernierDatePayTrimestriel());
            cal3.add(Calendar.MONTH,3);
            local.setDernierDatePayTrimestriel(cal3.getTime());
            entity.setLocal(local);
            taxeBoissonTrimestrielleDao.save(entity);
            return 1;

        }

    }
    @Autowired
    private RedevableServiceImpl redevableService;
    @Autowired
    private LocalServiceImpl localService;
    @Autowired
    private TauxTaxeTrimestrielleServiceImpl tauxTaxeTrimestrielleService;
    @Autowired
    private TaxeBoissonTrimestrielleDao taxeBoissonTrimestrielleDao;
}
