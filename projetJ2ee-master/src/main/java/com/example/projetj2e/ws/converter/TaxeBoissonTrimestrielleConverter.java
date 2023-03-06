package com.example.projetj2e.ws.converter;

import com.example.projetj2e.bean.TaxeBoissonTrimestrielle;
import com.example.projetj2e.ws.dto.TaxeBoissonTrimestielleDto;
import org.springframework.stereotype.Component;

@Component
public class TaxeBoissonTrimestrielleConverter extends AbstractConverter<TaxeBoissonTrimestrielle, TaxeBoissonTrimestielleDto>{

    @Override
    public TaxeBoissonTrimestielleDto toDto(TaxeBoissonTrimestrielle item) {
       TaxeBoissonTrimestielleDto dto =null;
       if(item!=null){
           dto = new TaxeBoissonTrimestielleDto();
            dto.setId(item.getId());
            dto.setLocal(item.getLocal());
            dto.setCategorieDeLocal(item.getCategorieDeLocal());
            dto.setTauxTaxeTrimestrielle(item.getTauxTaxeTrimestrielle());
            dto.setMontantBase(item.getMontantBase());
            dto.setMontantTotal(item.getMontantTotal());
            dto.setReference(item.getReference());
            dto.setRedevable(item.getRedevable());
            dto.setRetardMonths(item.getRetardMonths());
            dto.setMontantRetardPremierMois(item.getMontantRetardPremierMois());
            dto.setMontantRetardAutreMois(item.getMontantRetardAutreMois());
                   }
        return dto;
    }

    @Override
    public TaxeBoissonTrimestrielle toItem(TaxeBoissonTrimestielleDto dto) {
        TaxeBoissonTrimestrielle item=null;
        if(dto!=null){
            item=new TaxeBoissonTrimestrielle();
            item.setId(dto.getId());
            item.setLocal(dto.getLocal());
            item.setCategorieDeLocal(dto.getCategorieDeLocal());
            item.setTauxTaxeTrimestrielle(dto.getTauxTaxeTrimestrielle());
            item.setMontantBase(dto.getMontantBase());
            item.setMontantTotal(dto.getMontantTotal());
            item.setReference(dto.getReference());
            item.setRedevable(dto.getRedevable());
            item.setRetardMonths(dto.getRetardMonths());
            item.setMontantRetardPremierMois(dto.getMontantRetardPremierMois());
            item.setMontantRetardAutreMois(dto.getMontantRetardAutreMois());
        }
        return item;
    }
}
