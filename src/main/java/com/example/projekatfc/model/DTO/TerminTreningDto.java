package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class TerminTreningDto {
    private Long id;

    private Date vremePocetka;

    private Double cena;

    private Long TreningId;

    private String naziv;

    private String opis;

    private String tipTreninga;

    private Integer trajanje;

    public TerminTreningDto(Long id, Date vremePocetka, Double cena,  Long TreningId,  String naziv, String opis, String tipTreninga, Integer trajanje ) {
        this.id = id;
        this.vremePocetka = vremePocetka;
        this.cena = cena;
        this.TreningId = TreningId;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
    }

    public TerminTreningDto() {
    }

}
