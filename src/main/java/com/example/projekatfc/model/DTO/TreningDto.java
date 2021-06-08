package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TreningDto {
    private Long id;

    private String naziv;

    private String opis;

    private String tipTreninga;

    private Integer trajanje;

    private List<TerminDto> listaTermina;

    public TreningDto(Long id, String naziv, String opis, String tipTreninga, Integer trajanje, List<TerminDto> listaTermina) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.listaTermina = listaTermina;
    }

    public TreningDto() {
    }
}
