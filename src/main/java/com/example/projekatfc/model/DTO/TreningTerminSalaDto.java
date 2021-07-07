package com.example.projekatfc.model.DTO;

import com.example.projekatfc.model.Sala;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TreningTerminSalaDto {
        private Long id;

        private String naziv;

        private String opis;

        private String tipTreninga;

        private Integer trajanje;

        private Integer kapacitet;

        private String oznaka;

        private Sala sala;

        private List<TerminDto> listaTermina;

        public TreningTerminSalaDto(Long id, String naziv, String opis, String tipTreninga, Integer trajanje, Integer kapacitet, String oznaka, Sala sala, List<TerminDto> listaTermina) {
            this.id = id;
            this.naziv = naziv;
            this.opis = opis;
            this.tipTreninga = tipTreninga;
            this.trajanje = trajanje;
            this.kapacitet = kapacitet;
            this.oznaka = oznaka;
            this.sala = sala;
            this.listaTermina = listaTermina;
        }

        public TreningTerminSalaDto() {}
}
