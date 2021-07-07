package com.example.projekatfc.model.DTO;



import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ProfilDto {
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
    private String fitnesCentar;

    public ProfilDto(){}

    public ProfilDto(Long id, String korisnickoIme, String lozinka, String ime, String prezime, String telefon, String email, Date datumRodjenja, Boolean aktivan, String fitnesCentar) {
    }
}
