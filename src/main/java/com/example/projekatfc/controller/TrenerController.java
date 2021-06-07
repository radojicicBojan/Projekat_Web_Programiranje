package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.Korisnik;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.service.KorisnikService;
import com.example.projekatfc.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RequestMapping(value ="/api")
@RestController
@CrossOrigin
public class TrenerController {
    @Autowired
    private TrenerService trenerService;
    @GetMapping(value = "/approval", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDto>> getKorisnik() {
        List<Trener> treneri = this.trenerService.getAllUnactive();

        List<KorisnikDto> trenerDtos = new LinkedList<>();

        for(Trener korisnik: treneri) {
            KorisnikDto korisnikDto = new KorisnikDto();
            korisnikDto.setId(korisnik.getId());
            korisnikDto.setIme(korisnik.getIme());
            korisnikDto.setKorisnickoIme(korisnik.getKorisnickoIme());
            korisnikDto.setTelefon(korisnik.getTelefon());
            korisnikDto.setPrezime(korisnik.getPrezime());
            korisnikDto.setLozinka(korisnik.getLozinka());
            korisnikDto.setEmail(korisnik.getEmail());
            korisnikDto.setDatumRodjenja(korisnik.getDatumRodjenja());
            trenerDtos.add(korisnikDto);
        }

        return new ResponseEntity<>(trenerDtos, HttpStatus.OK);
    }
}
