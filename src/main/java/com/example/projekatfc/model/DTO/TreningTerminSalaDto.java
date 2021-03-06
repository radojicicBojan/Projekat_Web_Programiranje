package com.example.projekatfc.model.DTO;

import com.example.projekatfc.model.Sala;
import com.example.projekatfc.model.Termin;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class TreningTerminSalaDto {
        private Long id;

        private String naziv;

        private String opis;

        private String tipTreninga;

        private Integer trajanje;

        private Integer brojPrijavljenihClanova;

        private Integer kapacitet;

        private Integer brojSlobodnihMesta;

        private String oznaka;

        private Sala sala;

        private Double cena;

        private Double ocena;

        private Date vremePocetka;

        private Long terminId;

        private List<TerminSalaDto> listaTermina;

        public TreningTerminSalaDto(Long id, String naziv, String opis, String tipTreninga, Integer trajanje, Integer brojPrijavljenihClanova, Integer kapacitet, Integer brojSlobodnihMesta, String oznaka, Sala sala, Double cena, Double ocena,Date vremePocetka, List<TerminSalaDto> listaTermina, Long terminId) {
            this.id = id;
            this.naziv = naziv;
            this.opis = opis;
            this.tipTreninga = tipTreninga;
            this.trajanje = trajanje;
            this.brojPrijavljenihClanova = brojPrijavljenihClanova;
            this.kapacitet = kapacitet;
            this.brojSlobodnihMesta = brojSlobodnihMesta;
            this.oznaka = oznaka;
            this.sala = sala;
            this.cena = cena;
            this.ocena = ocena;
            this.vremePocetka = vremePocetka;
            this.listaTermina = listaTermina;
            this.terminId = terminId;
        }

        public TreningTerminSalaDto() {}
}
