package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Builder
@Data @NoArgsConstructor @AllArgsConstructor
@Entity
public class Subfamily {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name="familyid")
    private  Family family;
}
