package com.example.projekatfc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Prijava {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Double ocena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Clan clan;

    @ManyToOne(fetch = FetchType.EAGER)
    private Termin termin;

}