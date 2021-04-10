package com.example.model.dto.subfamily;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//necesitamos esta clase diferente a CreateUpdateDTOSubfamily, ya que para el de editar/crear necesita id, para saber donde enviar el formulario, en rest no necesitamos el id
public class CreateUpdateDTOSubfamilyWeb {
    private Long id;
    private String name;
    private Long familyid;
}
