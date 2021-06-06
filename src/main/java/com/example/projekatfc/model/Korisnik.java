package com.example.projekatfc.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;

import static javax.persistence.DiscriminatorType.STRING;
import static javax.persistence.InheritanceType.SINGLE_TABLE;

@Getter
@Setter
@Entity
@Table(name="korisnik")
// ovom anotacijom se naglasava tip mapiranja "jedna tabela po hijerarhiji"
@Inheritance(strategy=SINGLE_TABLE)
// ovom anotacijom se navodi diskriminatorska kolona
@DiscriminatorColumn(name="uloga", discriminatorType=STRING)
public abstract class Korisnik implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String korisnickoIme;

    @Column
    private String lozinka;

    @Column
    private String ime;

    @Column
    private String prezime;

    @Column
    private String telefon;

    @Column(unique = true)
    private String email;

    @Column
    private Date datumRodjenja;

    @Column
    private Boolean aktivan;

}