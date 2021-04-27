package com.example.model.dto.includedguide;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateUpdateIncludedGuideDTO {
    private Long id;
    private Long subfamilyId;
    private Long drugid;
}
