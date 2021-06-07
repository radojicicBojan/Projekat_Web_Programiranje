package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.DTO.TreningDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.model.Trening;
import com.example.projekatfc.service.FitnesCentarService;
import com.example.projekatfc.service.TreningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@CrossOrigin
@Controller
@RequestMapping(value = "/api")
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
            treningDtos.add(treningDto);
        }

        return new ResponseEntity<>(treningDtos, HttpStatus.OK);
    }
    @GetMapping("/")
    public String welcome() {return "homepage.html";}


}
