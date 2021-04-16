package com.example.model.service;

import com.example.error.exchange.ExchangeNotFoundException;
import com.example.error.subfamily.SubfamilyNotFoundException;
import com.example.model.dto.exchange.CreateExchangeDTO;
import com.example.model.dto.exchange.CreateUpdateExcangeDTOWeb;
import com.example.model.entity.Drug;
import com.example.model.entity.Exchange;
import com.example.model.entity.Subfamily;
import com.example.model.repository.ExchangeRepository;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExchangeService extends BaseService<Exchange, Long, ExchangeRepository> {

    private final DrugService drugService;
    private final SubfamilyService subfamilyService;

    public Page<Exchange> findAllExchanges(Pageable pageable) {
        return this.repositorio.findByQuery(pageable);
    }

    public Page<Exchange> findBySubfamilyId(Long id, Pageable pageable) {
        return this.repositorio.findBySubfamily_Id(id, pageable);
    }

    //funciona pero con el nombre exacto, sino no encuentra
    public Page<Exchange> findBySubfamilyName(String name, Pageable pageable) {
        return this.repositorio.findBySubfamily_Name(name, pageable);
    }

    public Page<Exchange> findBySubfamilyNameQuery(String name, Pageable pageable) {
        return this.repositorio.findBySubfamilyNameQuery(name, pageable);
    }

    public Page<Exchange> findByCurrentDrugId(Long id, Pageable pageable) {
        return this.repositorio.findByCurrentDrug_Id(id, pageable);
    }

    public Page<Exchange> findByAlternativeDrugId(Long id, Pageable pageable) {
        return this.repositorio.findByAlternativeDrug_Id(id, pageable);
    }

    public Exchange create(CreateExchangeDTO dto) {
        Drug current = drugService.findById(dto.getCurrentId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getCurrentId()));
        Drug alternative = drugService.findById(dto.getAlternativeId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getAlternativeId()));
        Subfamily subfamily = subfamilyService.findById(dto.getSubfamilyId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getSubfamilyId()));
        Exchange e = new Exchange();
        e.setCurrentDrug(current);
        e.setAlternativeDrug(alternative);
        e.setSubfamily(subfamily);
        return this.repositorio.save(e);
    }

    public Exchange update(CreateExchangeDTO dto, Long id) {
        Drug current = drugService.findById(dto.getCurrentId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getCurrentId()));
        Drug alternative = drugService.findById(dto.getAlternativeId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getAlternativeId()));
        Subfamily subfamily = subfamilyService.findById(dto.getSubfamilyId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getSubfamilyId()));
        Exchange e = this.repositorio.findById(id).orElseThrow(()-> new ExchangeNotFoundException(id));
        e.setCurrentDrug(current);
        e.setAlternativeDrug(alternative);
        e.setSubfamily(subfamily);
        return this.repositorio.save(e);
    }

    //WEB SERVICE
    public Exchange createWeb(CreateUpdateExcangeDTOWeb dto) {
        Drug current = drugService.findById(dto.getCurrentId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getCurrentId()));
        Drug alternative = drugService.findById(dto.getAlternativeId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getAlternativeId()));
        Subfamily subfamily = subfamilyService.findById(dto.getSubfamilyId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getSubfamilyId()));
        Exchange e = new Exchange();
        e.setCurrentDrug(current);
        e.setAlternativeDrug(alternative);
        e.setSubfamily(subfamily);
        return this.repositorio.save(e);
    }

    public Exchange updateWeb(CreateUpdateExcangeDTOWeb dto) {
        Drug current = drugService.findById(dto.getCurrentId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getCurrentId()));
        Drug alternative = drugService.findById(dto.getAlternativeId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getAlternativeId()));
        Subfamily subfamily = subfamilyService.findById(dto.getSubfamilyId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getSubfamilyId()));
        Exchange e = this.repositorio.findById(dto.getId()).orElseThrow(()-> new ExchangeNotFoundException(dto.getId()));
        e.setCurrentDrug(current);
        e.setAlternativeDrug(alternative);
        e.setSubfamily(subfamily);
        return this.repositorio.save(e);
    }

    public List<Exchange> findByCurrentNameWeb(String name) {
        List<Exchange> list = this.repositorio.findAll();
        List<Exchange> filteredList = new ArrayList<>();

        String nameClean = cleanAccentsAndWhiteSpaces(name.replaceAll("\\s",""));

        list.forEach(exchange -> {
            String cleanCurrentName = cleanAccentsAndWhiteSpaces(exchange.getCurrentDrug().getName().replaceAll("\\s",""));
            if (cleanCurrentName.contains(nameClean))
                filteredList.add(exchange);
        });
        return filteredList;
    }

    public List<Exchange> findByAlternativeNameWeb(String name) {
        List<Exchange> list = this.repositorio.findAll();
        List<Exchange> filteredList = new ArrayList<>();
        String nameClean = cleanAccentsAndWhiteSpaces(name);

        list.forEach(exchange -> {
            String cleanCurrentName = cleanAccentsAndWhiteSpaces(exchange.getAlternativeDrug().getName());
            if (cleanCurrentName.replace(" ", "").contains(nameClean.replace(" ", "")))
                filteredList.add(exchange);
        });

        return filteredList;
    }

    public List<Exchange> findBySubfamilyNameWeb(String name) {
        List<Exchange> list = this.repositorio.findAll();
        List<Exchange> filteredList = new ArrayList<>();
        System.out.println("findBySubfamilyNameWeb");
        String nameClean = cleanAccentsAndWhiteSpaces(name);

        list.forEach(exchange -> {
            String cleanCurrentName = cleanAccentsAndWhiteSpaces(exchange.getSubfamily().getName());
            if (cleanCurrentName.contains(nameClean))
                filteredList.add(exchange);

        });

        return filteredList;
    }



    public String cleanAccentsAndWhiteSpaces(String param) {
        String lowerParam = param.toLowerCase();
        // \\s equivale a cualquier tipo de carácter "blanco", espacios, tabuladores y retornos.
        String cadenaNormalize = Normalizer.normalize(lowerParam.replaceAll("\\s",""), Normalizer.Form.NFD);
        return cadenaNormalize.replaceAll("[^\\p{ASCII}]", "");
    }


}
