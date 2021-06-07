package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TreningDto {
    private Long id;

    private String naziv;

    private String opis;

    private String tipTreninga;

    private Integer trajanje;
}
