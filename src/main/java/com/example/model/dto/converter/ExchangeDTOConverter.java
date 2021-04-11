package com.example.model.dto.converter;

import com.example.model.dto.exchange.CreateUpdateExcangeDTOWeb;
import com.example.model.entity.Drug;
import com.example.model.entity.Exchange;
import com.example.model.entity.Subfamily;
import com.example.model.service.DrugService;
import com.example.model.service.ExchangeService;
import com.example.model.service.SubfamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ExchangeDTOConverter {
    private final ExchangeService exchangeService;
    private final DrugService drugService;
    private final SubfamilyService subfamilyService;

    public CreateUpdateExcangeDTOWeb convertEntityToDtoWeb(Exchange e) {
        return CreateUpdateExcangeDTOWeb.builder()
                .id(e.getId())
                .currentId(e.getCurrentDrug().getId())
                .alternativeId(e.getAlternativeDrug().getId())
                .subfamilyId(e.getSubfamily().getId())
                .build();
    }

    public Exchange convertDtoToEntityWeb(CreateUpdateExcangeDTOWeb dto) {
        Exchange e = exchangeService.findById(dto.getId()).orElse(null);
        Drug current = drugService.findById(dto.getCurrentId()).orElse(null);
        Drug alternative = drugService.findById(dto.getAlternativeId()).orElse(null);
        Subfamily subfamily = subfamilyService.findById(dto.getSubfamilyId()).orElse(null);

        e.setCurrentDrug(current);
        e.setAlternativeDrug(alternative);
        e.setSubfamily(subfamily);
        return e;

    }

}
