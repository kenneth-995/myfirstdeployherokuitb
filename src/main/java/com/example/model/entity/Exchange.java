package com.example.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "exchange")
//https://documenter.getpostman.com/view/11620031/TzCV3QNB POSTMAN
public class Exchange {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name = "currentdrugid")
    private Drug currentDrug;

    @ManyToOne
    @JoinColumn(name = "alternativedrugid")
    private Drug alternativeDrug;

    //@JsonBackReference
    @ManyToOne
    @JoinColumn(name = "subfamilyid") // importante para findBySubfamily_Id, si ponemos subfamily_id no encuentra nada
    private Subfamily subfamily;

    /**
     * Métodos helper
     */
//    public void addIntercambio(Intercambio intercambio) {
//        this.pathologicalSubfamily.addIntercambio(intercambio);
//    }
//
//    public void deleteIntercambio(Intercambio intercambio) {
//        this.pathologicalSubfamily.deleteIntercambio(intercambio);
//    }




}
