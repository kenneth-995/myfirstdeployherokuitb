package com.example.model.entity;

import javax.persistence.*;

@Table(name = "incluido_guia")
public class IncludedGuide {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "drud_id")
    private Drug drug;

    @ManyToOne
    @JoinColumn(name = "subfamily_id")
    private Subfamily subfamily;
}
