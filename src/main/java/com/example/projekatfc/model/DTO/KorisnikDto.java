package com.example.projekatfc.model.DTO;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.text.DateFormat;
import java.util.Date;

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
    private Date datumRodjenja;
    private Boolean aktivan;
    private String uloga;
    private Long fitnesCentarId;

    public KorisnikDto(){}

    public KorisnikDto(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Boolean aktivan, Long fitnesCentarId) {
        this.id = id;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.ime = ime;
        this.prezime = prezime;
        this.telefon = telefon;
        this.email = email;
        this.datumRodjenja = datumRodjenja;
        this.aktivan = aktivan;
        this.fitnesCentarId = fitnesCentarId;

    }
}
