package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TerminDto {
    private Long id;

    private Date vremePocetka;

    private Double cena;


    public TerminDto() {}

    public TerminDto(Long id, Date vremePocetka, Double cena) {
        this.id = id;
        this.vremePocetka = vremePocetka;
        this.cena = cena;
    }
}
