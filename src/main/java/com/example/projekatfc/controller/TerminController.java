package com.example.projekatfc.controller;


import com.example.projekatfc.model.*;
import com.example.projekatfc.model.DTO.*;
import com.example.projekatfc.service.TerminService;
import com.example.projekatfc.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "api/termini")
public class TerminController {
    @Autowired
    private TerminService terminService;
    @Autowired
    private TreningService treningService;

    public TerminController(TerminService terminService) {
        this.terminService = terminService;
    }

    @GetMapping("/termini")
    public List<Termin> findAll(){
        return terminService.findAll();
    }


    @GetMapping(value="/poceni/{cena}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrikazTreningaDto>> getTreningPoCeni(@PathVariable double cena) {
        List<Termin> listaTermina = this.terminService.findByCenaLessThanEqual(cena);

        List<PrikazTreningaDto> prikazTreningaDtos = new ArrayList<>();

        for (Termin termin : listaTermina) {

            PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto(
                    termin.getTrening().getId(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga(),
                    termin.getTrening().getTrajanje(),
                    termin.getId(),
                    termin.getVremePocetka(),
                    termin.getCena());
                prikazTreningaDtos.add(prikazTreningaDto);
        }

        return new ResponseEntity<>(prikazTreningaDtos, HttpStatus.OK);
    }

    @GetMapping(value="/povremenu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrikazTreningaDto>> getTreningPoVremenu(@RequestParam Date vremePocetka) {
        List<Termin> listaTermina = this.terminService.findAllByVremePocetka(vremePocetka);

        List<PrikazTreningaDto> prikazTreningaDtos = new ArrayList<>();

        for (Termin termin : listaTermina) {

            PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto(
                    termin.getTrening().getId(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga(),
                    termin.getTrening().getTrajanje(),
                    termin.getId(),
                    termin.getVremePocetka(),
                    termin.getCena());
            prikazTreningaDtos.add(prikazTreningaDto);
        }

        return new ResponseEntity<>(prikazTreningaDtos, HttpStatus.OK);
    }

    @GetMapping(value="/sortpoceni", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrikazTreningaDto>> getTreningSortPoCeni() {
        List<Termin> listaTermina = this.terminService.findAllByOrderByCena();

        List<PrikazTreningaDto> prikazTreningaDtos = new ArrayList<>();

        for (Termin termin : listaTermina) {

            PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto(
                    termin.getTrening().getId(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga(),
                    termin.getTrening().getTrajanje(),
                    termin.getId(),
                    termin.getVremePocetka(),
                    termin.getCena());
            prikazTreningaDtos.add(prikazTreningaDto);
        }
        return new ResponseEntity<>(prikazTreningaDtos, HttpStatus.OK);
    }

        @GetMapping(value="/sortpoceniopadajuce", produces = MediaType.APPLICATION_JSON_VALUE)
        public ResponseEntity<List<PrikazTreningaDto>> getTreningSortPoCeniOpadajuce() {
            List<Termin> listaTermina = this.terminService.findAllByOrderByCenaDesc();

            List<PrikazTreningaDto> prikazTreningaDtos = new ArrayList<>();

            for (Termin termin : listaTermina) {

                PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto(
                        termin.getTrening().getId(),
                        termin.getTrening().getNaziv(),
                        termin.getTrening().getOpis(),
                        termin.getTrening().getTipTreninga(),
                        termin.getTrening().getTrajanje(),
                        termin.getId(),
                        termin.getVremePocetka(),
                        termin.getCena());
                prikazTreningaDtos.add(prikazTreningaDto);
            }
            return new ResponseEntity<>(prikazTreningaDtos, HttpStatus.OK);
        }

    @GetMapping(value="/sortpovremenu", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrikazTreningaDto>> getTreningSortPoVremenu() {
        List<Termin> listaTermina = this.terminService.findAllByOrderByVremePocetka();

        List<PrikazTreningaDto> prikazTreningaDtos = new ArrayList<>();

        for (Termin termin : listaTermina) {

            PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto(
                    termin.getTrening().getId(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga(),
                    termin.getTrening().getTrajanje(),
                    termin.getId(),
                    termin.getVremePocetka(),
                    termin.getCena());
            prikazTreningaDtos.add(prikazTreningaDto);
        }
        return new ResponseEntity<>(prikazTreningaDtos, HttpStatus.OK);
    }

    @GetMapping(value="/sortpovremenuopadajuce", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PrikazTreningaDto>> getTreningSortPoVremenuOpadajuce() {
        List<Termin> listaTermina = this.terminService.findAllByOrderByVremePocetkaDesc();

        List<PrikazTreningaDto> prikazTreningaDtos = new ArrayList<>();

        for (Termin termin : listaTermina) {

            PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto(
                    termin.getTrening().getId(),
                    termin.getTrening().getNaziv(),
                    termin.getTrening().getOpis(),
                    termin.getTrening().getTipTreninga(),
                    termin.getTrening().getTrajanje(),
                    termin.getId(),
                    termin.getVremePocetka(),
                    termin.getCena());
            prikazTreningaDtos.add(prikazTreningaDto);
        }
        return new ResponseEntity<>(prikazTreningaDtos, HttpStatus.OK);
    }
    @GetMapping(value = "/ispis/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrikazTreningaDto> getTermin(@PathVariable Long id) {
        Termin termin = this.terminService.findOne(id);
        Trening trening = this.treningService.findOne(id);

        PrikazTreningaDto prikazTreningaDto = new PrikazTreningaDto();

        prikazTreningaDto.setId(trening.getId());
        prikazTreningaDto.setNaziv(trening.getNaziv());
        prikazTreningaDto.setTipTreninga(trening.getTipTreninga());
        prikazTreningaDto.setTrajanje(trening.getTrajanje());
        prikazTreningaDto.setOpis(trening.getOpis());
        prikazTreningaDto.setIdTermin(termin.getId());
        prikazTreningaDto.setVremePocetka(termin.getVremePocetka());
        prikazTreningaDto.setCena(termin.getCena());

        return new ResponseEntity<>(prikazTreningaDto, HttpStatus.OK);
    }

    @PutMapping(value = "/prijavaZaTrening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Termin> putTermin(@PathVariable Long id, @RequestBody TreningTerminSalaDto novTermin) {

        Termin termin = this.terminService.findOne(id);
        termin.setBrojPrijavljenihClanova(novTermin.getBrojPrijavljenihClanova()+1);


        return new ResponseEntity<>(termin, HttpStatus.OK);
    }

    @PutMapping(value = "/izmena/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PrikazTreningaDto> putTerminAndTrening(@PathVariable Long id, @RequestBody PrikazTreningaDto noviTerminAndTermin) {
        Termin termin = this.terminService.findOne(id);
        Trening trening = this.treningService.findOneByTerminiId(id);

        trening.setNaziv(noviTerminAndTermin.getNaziv());
        trening.setTipTreninga(noviTerminAndTermin.getTipTreninga());
        trening.setTrajanje(noviTerminAndTermin.getTrajanje());
        trening.setOpis(noviTerminAndTermin.getOpis());

        termin.setVremePocetka(noviTerminAndTermin.getVremePocetka());
        termin.setCena(noviTerminAndTermin.getCena());

        this.terminService.save(termin);
        this.treningService.save(trening);

        noviTerminAndTermin.setId(id);
        noviTerminAndTermin.setIdTermin(id);

        return new ResponseEntity<>(noviTerminAndTermin, HttpStatus.OK);
    }

    @PostMapping(value = "/dodavanjeTermina/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<TerminTreningDto> dodajTermin(@PathVariable Long id, @RequestBody TerminTreningDto novTermin) {
        Termin termin = terminService.addTermin(novTermin);

        novTermin.setId(id);
        novTermin.setTreningId(id);

        return new ResponseEntity<>(novTermin, HttpStatus.OK);
    }
}

