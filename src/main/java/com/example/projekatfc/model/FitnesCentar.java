package com.example.projekatfc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class FitnesCentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String naziv;
    @Column
    private String adresa;
    @Column
    private String telefon;
    @Column
    private String email;

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Sala> listaSala = new HashSet<>();

    @OneToMany(mappedBy = "fitnesCentar", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trener> listaTrenera = new HashSet<>();
}