package com.example.projekatfc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
public class Termin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date vremePocetka;

    @Column
    private Double cena;

    @ManyToOne(fetch = FetchType.EAGER)
    private Sala sala;

    @ManyToOne(fetch = FetchType.EAGER)
    private Trening trening;

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<OdradjenTrening> listaPrijava = new HashSet<>();

    @OneToMany(mappedBy = "termin", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RezervisanTrening> listaRezervacija = new HashSet<>();

    @Column
    private Integer brojPrijavljenihClanova;

}