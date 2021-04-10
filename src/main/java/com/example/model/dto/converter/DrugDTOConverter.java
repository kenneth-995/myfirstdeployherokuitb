package com.example.model.dto.converter;

import com.example.model.dto.drug.CreateUpdateDTODrug;
import com.example.model.entity.Drug;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DrugDTOConverter {
    public Drug convertDtoToEntity(CreateUpdateDTODrug dto) {

        return Drug.builder()
                .name(dto.getName())
                .dose(dto.getDose())
                .build();

    }
}
