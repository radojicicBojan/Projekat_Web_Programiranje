package com.example.projekatfc.controller;


import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class FitnesCentarController {
    @Autowired
    private FitnesCentarService fitnesCentarService;

    public FitnesCentarController(FitnesCentarService fitnesCentarService) {
        this.fitnesCentarService = fitnesCentarService;
    }

    @PostMapping(value = "/dodavanjeFitnesCentra")
    public ResponseEntity<FitnesCentarDto> addFitnesCentar(@RequestParam String uloga, @RequestBody FitnesCentarDto noviFitnesCentar){
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FitnesCentar fitnesCentar = fitnesCentarService.dodajFitnesCentar(noviFitnesCentar);
            noviFitnesCentar.setId(fitnesCentar.getId());
            return new ResponseEntity<>(noviFitnesCentar, HttpStatus.CREATED);

        }
    @GetMapping(value = "/fitnesCentri", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDto>> getFitnesCentar(@RequestParam String uloga) {
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        List<FitnesCentar> fitnesCentri = this.fitnesCentarService.getAll();

        List<FitnesCentarDto> fitnesCentarDtos = new LinkedList<>();

        for(FitnesCentar fitnesCentar: fitnesCentri) {
            FitnesCentarDto fitnesCentarDto = new FitnesCentarDto();
            fitnesCentarDto.setId(fitnesCentar.getId());
            fitnesCentarDto.setAdresa(fitnesCentar.getAdresa());
            fitnesCentarDto.setEmail(fitnesCentar.getEmail());
            fitnesCentarDto.setNaziv(fitnesCentar.getNaziv());
            fitnesCentarDto.setTelefon(fitnesCentar.getTelefon());
            fitnesCentarDtos.add(fitnesCentarDto);
        }

        return new ResponseEntity<>(fitnesCentarDtos, HttpStatus.OK);
    }

    @GetMapping(value = "/fitnesCentri/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDto> getFitnesCentar(@PathVariable Long id, @RequestParam String uloga) {
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FitnesCentar fitnesCentar = this.fitnesCentarService.findById(id);
            FitnesCentarDto fitnesCentarDto = new FitnesCentarDto();
            fitnesCentarDto.setId(fitnesCentar.getId());
            fitnesCentarDto.setAdresa(fitnesCentar.getAdresa());
            fitnesCentarDto.setEmail(fitnesCentar.getEmail());
            fitnesCentarDto.setNaziv(fitnesCentar.getNaziv());
            fitnesCentarDto.setTelefon(fitnesCentar.getTelefon());

        return new ResponseEntity<>(fitnesCentarDto, HttpStatus.OK);
    }

    @GetMapping(value = "/fitnesCentri/prikaz", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FitnesCentarDto>> getFitnesCentar() {
        List<FitnesCentar> fitnesCentri = this.fitnesCentarService.getAll();

        List<FitnesCentarDto> fitnesCentarDtos = new LinkedList<>();

        for(FitnesCentar fitnesCentar: fitnesCentri) {
            FitnesCentarDto fitnesCentarDto = new FitnesCentarDto();
            fitnesCentarDto.setId(fitnesCentar.getId());
            fitnesCentarDto.setAdresa(fitnesCentar.getAdresa());
            fitnesCentarDto.setEmail(fitnesCentar.getEmail());
            fitnesCentarDto.setNaziv(fitnesCentar.getNaziv());
            fitnesCentarDto.setTelefon(fitnesCentar.getTelefon());
            fitnesCentarDtos.add(fitnesCentarDto);
        }

        return new ResponseEntity<>(fitnesCentarDtos, HttpStatus.OK);
    }

    @PutMapping(value = "/fitnesCentri/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<FitnesCentarDto> putFitnesCentar(@PathVariable Long id, @RequestParam String uloga, @RequestBody FitnesCentarDto noviFitnesCentar) {
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        FitnesCentar fitnesCentar = this.fitnesCentarService.findById(id);

        fitnesCentar.setNaziv(noviFitnesCentar.getNaziv());
        fitnesCentar.setAdresa(noviFitnesCentar.getAdresa());
        fitnesCentar.setEmail(noviFitnesCentar.getEmail());
        fitnesCentar.setTelefon(noviFitnesCentar.getTelefon());

        this.fitnesCentarService.save(fitnesCentar);

        noviFitnesCentar.setId(id);

        return new ResponseEntity<>(noviFitnesCentar, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus approve(@RequestBody List<Long> ids, @RequestParam String uloga) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            return HttpStatus.BAD_REQUEST;
        }

        for(Long id: ids) {
            FitnesCentar fc = fitnesCentarService.findById(id);
            fitnesCentarService.delete(fc);
        }
        return HttpStatus.OK;
    }
}