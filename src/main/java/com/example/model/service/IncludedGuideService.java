package com.example.model.service;

import com.example.error.drug.DrugNotFoundException;
import com.example.error.subfamily.SubfamilyNotFoundException;
import com.example.model.dto.includedguide.CreateUpdateIncludedGuideDTO;
import com.example.model.entity.Drug;
import com.example.model.entity.Exchange;
import com.example.model.entity.IncludedGuide;
import com.example.model.entity.Subfamily;
import com.example.model.repository.RepositoryIncludedGuide;
import com.example.model.service.base.BaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IncludedGuideService extends BaseService<IncludedGuide, Long, RepositoryIncludedGuide> {
    private final DrugService drugService;
    private final SubfamilyService subfamilyService;

    // WEB SERVICE
    public IncludedGuide createWeb(CreateUpdateIncludedGuideDTO dto) {
        Drug drug = drugService.findById(dto.getDrugid()).orElseThrow(()-> new DrugNotFoundException(dto.getDrugid()));
        Subfamily subfamily = subfamilyService.findById(dto.getSubfamilyId()).orElseThrow(()-> new SubfamilyNotFoundException(dto.getSubfamilyId()));
        IncludedGuide includedGuide = new IncludedGuide();
        includedGuide.setSubfamily(subfamily);
        includedGuide.setDrug(drug);
        return this.repositorio.save(includedGuide);
    }

    public List<IncludedGuide> findByDrugNameWeb(String name) {
        List<IncludedGuide> list = this.repositorio.findAll();
        List<IncludedGuide> filteredList = new ArrayList<>();

        String nameClean = cleanAccentsAndWhiteSpaces(name.replaceAll("\\s",""));

        list.forEach(included -> {
            String cleanDrugName = cleanAccentsAndWhiteSpaces(included.getDrug().getName().replaceAll("\\s",""));
            if (cleanDrugName.contains(nameClean))
                filteredList.add(included);
        });
        return filteredList;
    }

    public List<IncludedGuide> findBySubfamilyNameWeb(String name) {
        List<IncludedGuide> list = this.repositorio.findAll();
        List<IncludedGuide> filteredList = new ArrayList<>();

        String nameClean = cleanAccentsAndWhiteSpaces(name.replaceAll("\\s",""));

        list.forEach(included -> {
            String cleanSubfamilyName = cleanAccentsAndWhiteSpaces(included.getSubfamily().getName().replaceAll("\\s",""));
            if (cleanSubfamilyName.contains(nameClean))
                filteredList.add(included);
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
