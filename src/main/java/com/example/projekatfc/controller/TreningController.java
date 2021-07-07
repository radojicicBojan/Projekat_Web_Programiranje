package com.example.projekatfc.controller;

import com.example.projekatfc.model.*;
import com.example.projekatfc.model.DTO.*;
import com.example.projekatfc.service.FitnesCentarService;
import com.example.projekatfc.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/api/treninzi")
public class TreningController {

    @Autowired
    private TreningService treningService;

    public TreningController(TreningService treningService) {
        this.treningService = treningService;
    }

    @PostMapping(value = "/dodajTrening")
    public ResponseEntity<TreningDto> showTreining(@RequestBody TreningDto noviTrening){
        Trening trening = treningService.dodajTrening(noviTrening);
        noviTrening.setId(trening.getId());
        return new ResponseEntity<>(noviTrening, HttpStatus.CREATED);
    }
    @PostMapping(value = "/addTraining/{id}")
    public ResponseEntity<TreningTrenerDto> dodavanjeTreninga(@RequestParam Long ID, @RequestBody TreningTrenerDto newTrening){

        Trening trening = treningService.dodajTreningTrener(newTrening);
        newTrening.setId(trening.getId());
        newTrening.setTrenerId(ID);
        return new ResponseEntity<>(newTrening, HttpStatus.CREATED);

    }
    @GetMapping(value = "/prikazTreninga", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getTrening() {
        List<Trening> treninzi = this.treningService.findAll();

        List<TreningDto> treningDtos = new LinkedList<>();

        for(Trening trening: treninzi) {
            TreningDto treningDto = new TreningDto();
            treningDto.setId(trening.getId());
            treningDto.setNaziv(trening.getNaziv());
            treningDto.setOpis(trening.getOpis());
            treningDto.setTipTreninga(trening.getTipTreninga());
            treningDto.setTrajanje(trening.getTrajanje());
            List<TerminDto> listaTerminaDto = new ArrayList<>();
            for(Termin termin: trening.getTermini()){
                TerminDto terminDto = new TerminDto();
                terminDto.setCena(termin.getCena());
                terminDto.setVremePocetka(termin.getVremePocetka());
                terminDto.setId(termin.getId());
                listaTerminaDto.add(terminDto);
            }
            treningDto.setListaTermina(listaTerminaDto);
            treningDtos.add(treningDto);
        }

        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/prosireniPrikazTreninga/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TreningTerminSalaDto> getTrainingDetails(@PathVariable Long id) {
        Trening trening = this.treningService.findOneByTerminiId(id);
        List<TreningTerminSalaDto> treningDtos = new LinkedList<>();
        TreningTerminSalaDto treningDto = new TreningTerminSalaDto();
        treningDto.setId(trening.getId());
        treningDto.setNaziv(trening.getNaziv());
        treningDto.setOpis(trening.getOpis());
        treningDto.setTipTreninga(trening.getTipTreninga());
        treningDto.setTrajanje(trening.getTrajanje());

        List<TerminDto> listaTerminaDto = new ArrayList<>();
        for(Termin termin: trening.getTermini()){
            TerminDto terminDto = new TerminDto();
            terminDto.setCena(termin.getCena());
            terminDto.setVremePocetka(termin.getVremePocetka());
            terminDto.setId(termin.getId());
            listaTerminaDto.add(terminDto);
        }
        treningDto.setListaTermina(listaTerminaDto);
        treningDtos.add(treningDto);

        Sala sala = new Sala();
        treningDto.setKapacitet(sala.getKapacitet());
        treningDto.setOznaka(sala.getOznaka());

        return new ResponseEntity<>(treningDto, HttpStatus.OK);
    }

    @GetMapping(value = "/prikazTreninga/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getTreningOfTrener(@PathVariable Long id) {
        List<Trening> treninzi = this.treningService.findAllByTrenerId(id);

        List<TreningDto> treningDtos = new LinkedList<>();

        for(Trening trening: treninzi) {
            TreningDto treningDto = new TreningDto();
            treningDto.setId(trening.getId());
            treningDto.setNaziv(trening.getNaziv());
            treningDto.setOpis(trening.getOpis());
            treningDto.setTipTreninga(trening.getTipTreninga());
            treningDto.setTrajanje(trening.getTrajanje());
            List<TerminDto> listaTerminaDto = new ArrayList<>();
            for(Termin termin: trening.getTermini()){
                TerminDto terminDto = new TerminDto();
                terminDto.setCena(termin.getCena());
                terminDto.setVremePocetka(termin.getVremePocetka());
                terminDto.setId(termin.getId());
                listaTerminaDto.add(terminDto);
            }
            treningDto.setListaTermina(listaTerminaDto);
            treningDtos.add(treningDto);
        }

        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/prikazListeTreninga/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getTrainingsOfTrener(@PathVariable Long id) {
        List<Trening> treninzi = this.treningService.findAllByTrenerId(id);

        List<TreningDto> treningDtos = new LinkedList<>();

        for(Trening trening: treninzi) {
            TreningDto treningDto = new TreningDto();
            treningDto.setId(trening.getId());
            treningDto.setNaziv(trening.getNaziv());
            treningDto.setOpis(trening.getOpis());
            treningDto.setTipTreninga(trening.getTipTreninga());
            treningDto.setTrajanje(trening.getTrajanje());
            treningDtos.add(treningDto);
        }

        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }

    @GetMapping(value="/ponazivu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getTreningPoNazivu(@RequestParam String naziv) {
        // Pozivanjem metode servisa dobavljamo sve zaposlene
        List<Trening> listaTreninga = this.treningService.findAllByNazivContaining(naziv);

        // Kreiramo listu DTO objekata koju ćemo vratiti u odgovoru na zahtev
        List<TreningDto> treningDtos = new ArrayList<>();

        for (Trening trening : listaTreninga) {
            // Kreiramo EmployeeDTO za svakog zaposlenog, kojeg je vratila metoda findAll()
            // i ubacujemo ga u listu employeeDTOS
            List<TerminDto> terminDtos = new ArrayList<>();
            for(Termin termini : trening.getTermini()) {
                terminDtos.add(new TerminDto(termini.getId(), termini.getVremePocetka(), termini.getCena()));
            }
            TreningDto treningDto = new TreningDto(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje(), terminDtos);
            treningDtos.add(treningDto);
        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }

    @GetMapping(value="/potipu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getTreningPoTipu(@RequestParam String tipTreninga) {
        // Pozivanjem metode servisa dobavljamo sve zaposlene
        List<Trening> listaTreninga = this.treningService.findAllByTipTreningaContaining(tipTreninga);

        // Kreiramo listu DTO objekata koju ćemo vratiti u odgovoru na zahtev
        List<TreningDto> treningDtos = new ArrayList<>();

        for (Trening trening : listaTreninga) {
            // Kreiramo EmployeeDTO za svakog zaposlenog, kojeg je vratila metoda findAll()
            // i ubacujemo ga u listu employeeDTOS
            List<TerminDto> terminDtos = new ArrayList<>();
            for(Termin termini : trening.getTermini()) {
                terminDtos.add(new TerminDto(termini.getId(), termini.getVremePocetka(), termini.getCena()));
            }
            TreningDto treningDto = new TreningDto(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje(), terminDtos);
            treningDtos.add(treningDto);
        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }

    @GetMapping(value="/poopisu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningDto>> getTreningPoOpisu(@RequestParam String opis) {
        // Pozivanjem metode servisa dobavljamo sve zaposlene
        List<Trening> listaTreninga = this.treningService.findAllByOpisContaining(opis);

        // Kreiramo listu DTO objekata koju ćemo vratiti u odgovoru na zahtev
        List<TreningDto> treningDtos = new ArrayList<>();

        for (Trening trening : listaTreninga) {
            // Kreiramo EmployeeDTO za svakog zaposlenog, kojeg je vratila metoda findAll()
            // i ubacujemo ga u listu employeeDTOS
            List<TerminDto> terminDtos = new ArrayList<>();
            for(Termin termini : trening.getTermini()) {
                terminDtos.add(new TerminDto(termini.getId(), termini.getVremePocetka(), termini.getCena()));
            }
            TreningDto treningDto = new TreningDto(trening.getId(), trening.getNaziv(),
                    trening.getOpis(), trening.getTipTreninga(), trening.getTrajanje(), terminDtos);
            treningDtos.add(treningDto);
        }

        // Vraćamo odgovor 200 OK, a kroz body odgovora šaljemo podatke o pronađenim zaposlenima
        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }



}
