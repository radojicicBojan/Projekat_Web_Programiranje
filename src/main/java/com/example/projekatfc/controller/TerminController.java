package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.PrikazTreningaDto;
import com.example.projekatfc.model.DTO.TerminDto;
import com.example.projekatfc.model.DTO.TreningDto;
import com.example.projekatfc.model.Termin;
import com.example.projekatfc.model.Trening;
import com.example.projekatfc.repository.TerminRepository;
import com.example.projekatfc.service.TerminService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "api/termini")
public class TerminController {
    private  final TerminService terminService;

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
}
