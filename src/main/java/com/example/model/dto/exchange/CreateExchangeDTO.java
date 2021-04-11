package com.example.model.dto.exchange;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateExchangeDTO {
    private Long currentId;
    private Long alternativeId;
    private Long subfamilyId;
}
