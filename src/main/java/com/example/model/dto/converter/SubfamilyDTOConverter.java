package com.example.model.dto.converter;

import com.example.model.dto.CreateUptateDTOSubfamily;
import com.example.model.entity.Family;
import com.example.model.entity.Subfamily;
import com.example.model.service.FamilyService;
import com.example.model.service.SubfamilyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SubfamilyDTOConverter {
    @Autowired
    private final FamilyService familyService;
    @Autowired
    private final SubfamilyService subfamilyService;

    public CreateUptateDTOSubfamily convertEntityToDto(Subfamily subfamily){
        System.out.println("convertEntityToDto(Subfamily subfamily) = " + subfamily.toString());
        CreateUptateDTOSubfamily s =  CreateUptateDTOSubfamily.builder()
                .id(subfamily.getId())
                .name(subfamily.getName())
                .familyid(subfamily.getFamily().getId())
                .build();

        return s;
    }

    public Subfamily convertDtoToEntity(CreateUptateDTOSubfamily subfamilydto) {

        Family family = familyService.findById(subfamilydto.getFamilyid()).orElse(null);

        return Subfamily.builder()
                .id(subfamilydto.getId())
                .name(subfamilydto.getName())
                .family(family)
                .build();

    }
}
