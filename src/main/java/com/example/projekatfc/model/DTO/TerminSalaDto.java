package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TerminSalaDto {
    private Long id;

    private Date vremePocetka;

    private Double cena;

    private Long sala_id;

    private Integer kapacitet;

    private String oznaka;


    public TerminSalaDto() {}

    public TerminSalaDto(Long id, Date vremePocetka, Double cena, Long sala_id, Integer kapacitet, String oznaka) {
        this.id = id;
        this.vremePocetka = vremePocetka;
        this.cena = cena;
        this.sala_id = sala_id;
        this.kapacitet = kapacitet;
        this.oznaka = oznaka;
    }
}
