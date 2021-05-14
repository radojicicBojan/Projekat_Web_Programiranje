package com.example.projekatfc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@DiscriminatorValue("TRENER")
public class Trener extends Korisnik{
    @ManyToOne(fetch = FetchType.EAGER)
    private FitnesCentar fitnesCentar;

    @OneToMany(mappedBy = "trener", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Trening> listaTreninga = new HashSet<>();
}