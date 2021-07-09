package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.SalaDto;
import com.example.projekatfc.model.DTO.SalaFCDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.service.FitnesCentarService;
import com.example.projekatfc.service.SalaService;
import com.example.projekatfc.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@CrossOrigin
@RestController
@RequestMapping(value = "/api")
public class SalaController {
    @Autowired
    private SalaService salaService;

    @Autowired
    private TrenerService trenerService;

    @Autowired
    private FitnesCentarService fitnesCentarService;

    public SalaController(SalaService salaService) {

        this.salaService = salaService;
    }

    @PostMapping(value = "/dodavanjeSale")
    public ResponseEntity<SalaFCDto> addSala(@RequestBody SalaFCDto novaSala){
        Sala sala = salaService.dodajSalu(novaSala);
        novaSala.setId(sala.getId());

        return new ResponseEntity<>(novaSala, HttpStatus.CREATED);
    }
    @GetMapping(value = "/sale/fitnesCentar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaFCDto>> getSalaFromFitnesCentar(@PathVariable Long id) {
        FitnesCentar fitnesCentar = fitnesCentarService.findById(id);

        Set<Sala> sale = fitnesCentar.getListaSala();

        List<SalaFCDto> salaFCDtos = new LinkedList<>();

            for (Sala sala : sale) {
                SalaFCDto salaFCDto = new SalaFCDto();
                salaFCDto.setId(sala.getId());
                salaFCDto.setKapacitet(sala.getKapacitet());
                salaFCDto.setOznaka(sala.getOznaka());
                salaFCDto.setFitnesCentarID(sala.getFitnesCentar().getId());
                salaFCDtos.add(salaFCDto);
            }
            return new ResponseEntity<>(salaFCDtos, HttpStatus.OK);

    }
    @GetMapping(value = "/sale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> getSala(@PathVariable Long id) {
        Sala sala = this.salaService.findOne(id);

        SalaDto salaDto = new SalaDto();
        salaDto.setId(sala.getId());
        salaDto.setKapacitet(sala.getKapacitet());
        salaDto.setOznaka(sala.getOznaka());
        salaDto.setFitnesCentarId(sala.getFitnesCentar().getId());


        return new ResponseEntity<>(salaDto, HttpStatus.OK);
    }

    @PutMapping(value = "/sale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> putSala(@PathVariable Long id, @RequestParam String uloga, @RequestBody SalaDto novaSala) {
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Sala sala = this.salaService.findOne(id);

        sala.setKapacitet(novaSala.getKapacitet());
        sala.setOznaka(novaSala.getOznaka());

        this.salaService.save(sala);

        novaSala.setId(id);

        return new ResponseEntity<>(novaSala, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/deleteSala", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus approve(@RequestParam String uloga, @RequestBody List<Long> ids) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            return HttpStatus.BAD_REQUEST;
        }

        for(Long id: ids) {
            Sala sala = salaService.findOne(id);
            salaService.delete(sala);
        }
        return HttpStatus.OK;
    }
}
