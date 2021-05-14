package com.example.projekatfc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Sala {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private Integer kapacitet;
    @Column
    private String oznaka;

    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    @OneToMany(mappedBy = "sala", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Termin> terminiTreninga = new HashSet<>();
}