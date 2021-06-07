package com.example.projekatfc.controller;


import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.service.FitnesCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<FitnesCentarDto> addFitnesCentar(@RequestBody FitnesCentarDto noviFitnesCentar){
            FitnesCentar fitnesCentar = fitnesCentarService.dodajFitnesCentar(noviFitnesCentar);
            noviFitnesCentar.setId(fitnesCentar.getId());
            return new ResponseEntity<>(noviFitnesCentar, HttpStatus.CREATED);

        }
}
