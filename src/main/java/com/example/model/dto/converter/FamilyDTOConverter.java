package com.example.model.dto.converter;

import com.example.model.dto.family.CreateUpdateDTOFamily;
import com.example.model.entity.Family;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FamilyDTOConverter {

    public Family convertDtoToEntity(CreateUpdateDTOFamily dtoFamily){

        return Family.builder()
                .name(dtoFamily.getName())
                .build();
    }
}
