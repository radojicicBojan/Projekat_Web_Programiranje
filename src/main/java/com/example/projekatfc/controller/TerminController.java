package com.example.projekatfc.controller;


import com.example.projekatfc.model.*;
import com.example.projekatfc.model.DTO.*;
import com.example.projekatfc.service.ClanService;
import com.example.projekatfc.service.TerminService;
import com.example.projekatfc.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin
@RestController
@RequestMapping(value = "api/termini")
public class TerminController {
    @Autowired
    private TerminService terminService;
    @Autowired
    private TreningService treningService;
    @Autowired
    private ClanService clanService;

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

    @PostMapping(value = "/prijavaZaTrening/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> putTermin(@PathVariable Long id, @RequestBody Long clanId) {

        Termin termin = this.terminService.findOne(id);
        Clan clan = clanService.findOneById(clanId);

        if(termin.getBrojPrijavljenihClanova() >= termin.getSala().getKapacitet()){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        if(clanService.prijavaZaTermin(clan, termin)){
            return new ResponseEntity<>("Kreirano" ,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @PostMapping(value = "/otkazivanjePrijave/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> otkazivanjePrijave(@PathVariable Long id, @RequestBody Long clanId) {

        Termin termin = this.terminService.findOne(id);
        Clan clan = clanService.findOneById(clanId);

        if(clanService.otkazivanjePrijaveZaTermin(clan, termin)){
            return new ResponseEntity<>("Otkazano" ,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

    @GetMapping(value = "/prikazPrijavljenihTreninga/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningTerminSalaDto>> getPrijavljeniTreninzi(@PathVariable Long id) {
        Clan clan = this.clanService.findOneById(id);
        Set<RezervisanTrening> termins = clan.getListaRezervisanihTermina();
        List<TreningTerminSalaDto> terminDtos = new ArrayList<>();

        for(RezervisanTrening trening: termins) {
            TreningTerminSalaDto treningTerminSalaDto = new TreningTerminSalaDto();
            treningTerminSalaDto.setId(trening.getId());
            treningTerminSalaDto.setNaziv(trening.getTermin().getTrening().getNaziv());
            treningTerminSalaDto.setTipTreninga(trening.getTermin().getTrening().getTipTreninga());
            treningTerminSalaDto.setOpis(trening.getTermin().getTrening().getOpis());
            treningTerminSalaDto.setTrajanje(trening.getTermin().getTrening().getTrajanje());
            treningTerminSalaDto.setCena(trening.getTermin().getCena());
            treningTerminSalaDto.setVremePocetka(trening.getTermin().getVremePocetka());
            treningTerminSalaDto.setOznaka(trening.getTermin().getSala().getOznaka());
            treningTerminSalaDto.setBrojPrijavljenihClanova(trening.getTermin().getBrojPrijavljenihClanova());
            terminDtos.add(treningTerminSalaDto);

        }

        return new ResponseEntity<>(terminDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/prikazOdradjenihTreninga/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<TreningTerminSalaDto>> getOdradjeniTreninzi(@PathVariable Long id) {
        Clan clan = this.clanService.findOneById(id);
        Set<OdradjenTrening> termins = clan.getListaOdradjenihTreninga();
        List<TreningTerminSalaDto> terminDtos = new ArrayList<>();

        for(OdradjenTrening trening: termins) {
            TreningTerminSalaDto treningTerminSalaDto = new TreningTerminSalaDto();
            treningTerminSalaDto.setId(trening.getId());
            treningTerminSalaDto.setNaziv(trening.getTermin().getTrening().getNaziv());
            treningTerminSalaDto.setTipTreninga(trening.getTermin().getTrening().getTipTreninga());
            treningTerminSalaDto.setOpis(trening.getTermin().getTrening().getOpis());
            treningTerminSalaDto.setTrajanje(trening.getTermin().getTrening().getTrajanje());
            treningTerminSalaDto.setCena(trening.getTermin().getCena());
            treningTerminSalaDto.setOznaka(trening.getTermin().getSala().getOznaka());
            treningTerminSalaDto.setOcena(trening.getOcena());
            treningTerminSalaDto.setBrojPrijavljenihClanova(trening.getTermin().getBrojPrijavljenihClanova());
            terminDtos.add(treningTerminSalaDto);

        }

        return new ResponseEntity<>(terminDtos, HttpStatus.OK);
    }
}

