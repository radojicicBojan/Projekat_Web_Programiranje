package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;

@Getter
@Setter
public class KorisnikDto {

    private Long id;
    private String korisnickoIme;
    private String lozinka;
    private String ime;
    private String prezime;
    private String telefon;
    private String email;
    private String datumRodjenja;
    private Boolean aktivan;
    private String uloga;

    public KorisnikDto(){}
}
