package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.SalaDto;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.service.SalaService;
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
    @GetMapping(value = "/sale/fitnesCentar/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<SalaDto>> getSalaFromFitnesCentar(@PathVariable Long id) {
        List<Sala> sale = this.salaService.getAll();
        Sala sala = new Sala();

        List<SalaDto> salaDtos = new LinkedList<>();

        if (sala.getFitnesCentar().getId() == id) {
            for (Sala s : sale) {
                SalaDto salaDto = new SalaDto();
                salaDto.setId(sala.getId());
                salaDto.setKapacitet(sala.getKapacitet());
                salaDto.setOznaka(sala.getOznaka());
                salaDtos.add(salaDto);
            }
            return new ResponseEntity<>(salaDtos, HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(salaDtos, HttpStatus.OK);
        }
    }
    @GetMapping(value = "/sale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> getSala(@PathVariable Long id) {
        Sala sala = this.salaService.findOne(id);

        SalaDto salaDto = new SalaDto();
        salaDto.setId(sala.getId());
        salaDto.setKapacitet(sala.getKapacitet());
        salaDto.setOznaka(sala.getOznaka());


        return new ResponseEntity<>(salaDto, HttpStatus.OK);
    }

    @PutMapping(value = "/sale/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<SalaDto> putSala(@PathVariable Long id, @RequestBody SalaDto novaSala) {
        Sala sala = this.salaService.findOne(id);

        sala.setKapacitet(novaSala.getKapacitet());
        sala.setOznaka(novaSala.getOznaka());

        this.salaService.save(sala);

        novaSala.setId(id);

        return new ResponseEntity<>(novaSala, HttpStatus.OK);
    }
    
    @DeleteMapping(value = "/deleteSala", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus approve(@RequestBody List<Long> ids) throws Exception{
        for(Long id: ids) {
            Sala sala = salaService.findOne(id);
            salaService.delete(sala);
        }
        return HttpStatus.OK;
    }
}
