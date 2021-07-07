package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreningTrenerDto {
    private Long id;

    private String naziv;

    private String opis;

    private String tipTreninga;

    private Integer trajanje;

    private Long trenerId;

    public TreningTrenerDto(Long id, String naziv, String opis, String tipTreninga, Integer trajanje, Long trenerId) {
        this.id = id;
        this.naziv = naziv;
        this.opis = opis;
        this.tipTreninga = tipTreninga;
        this.trajanje = trajanje;
        this.trenerId = trenerId;

    }

    public TreningTrenerDto() {
    }
}
