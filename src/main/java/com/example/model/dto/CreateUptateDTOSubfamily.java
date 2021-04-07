package com.example.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUptateDTOSubfamily {
    private Long id;
    private String name;
    private Long familyid;
}
