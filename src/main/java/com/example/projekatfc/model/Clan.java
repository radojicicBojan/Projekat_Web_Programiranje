package com.example.projekatfc.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter

@Entity
@DiscriminatorValue("CLAN")
public class Clan extends Korisnik{
    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Prijava> listaOdradjenihTreninga = new HashSet<>();

    @OneToMany(mappedBy = "clan", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<RezervisanTrening> listaRezervisanihTermina = new HashSet<>();
}