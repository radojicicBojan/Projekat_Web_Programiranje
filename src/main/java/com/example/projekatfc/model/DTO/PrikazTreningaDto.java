package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class PrikazTreningaDto {
    private Long id;

    private String naziv;

    private String opis;

    private String tipTreninga;

    private Integer trajanje;

    private Long idTermin;

    private Date vremePocetka;

    private Double cena;

    public PrikazTreningaDto(Long id, String naziv, String opis, String tipTreninga, Integer trajanje, Long idTermin, Date vremePocetka, Double cena) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.idTermin = idTermin;
        this.vremePocetka = vremePocetka;
        this.cena = cena;
    }

    public PrikazTreningaDto() {}
}
