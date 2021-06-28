package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.DTO.SalaDto;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.service.SalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class SalaController {
    @Autowired
    private SalaService salaService;

    public SalaController(SalaService salaService) {

        this.salaService = salaService;
    }

    @PostMapping(value = "/dodavanjeSale")
    public ResponseEntity<SalaDto> addSala(@RequestBody SalaDto novaSala){
        Sala sala = salaService.dodajSalu(novaSala);
        novaSala.setId(sala.getId());
        return new ResponseEntity<>(novaSala, HttpStatus.CREATED);

    }
}
