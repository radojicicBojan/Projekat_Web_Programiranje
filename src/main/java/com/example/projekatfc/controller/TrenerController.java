package com.example.projekatfc.controller;

import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.FitnesCentar;
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
    public ResponseEntity<List<KorisnikDto>> getKorisnik(@RequestParam String uloga) {
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
    @PutMapping(value = "/approval", produces = MediaType.APPLICATION_JSON_VALUE)
        public HttpStatus approve(@RequestParam String uloga, @RequestBody List<Long> ids) throws Exception{
        if(!uloga.equals("ADMINISTRATOR")){
            return HttpStatus.BAD_REQUEST;
        }

        for(Long id: ids) {
            Trener t = trenerService.findOne(id);
            t.setAktivan(true);
            trenerService.update(t);
        }
        return HttpStatus.OK;
    }

    @GetMapping(value = "/coaches", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<KorisnikDto>> getTrener(@RequestParam String uloga) {
        if(!uloga.equals("ADMINISTRATOR")){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        List<Trener> treneri = this.trenerService.getAll();

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
            korisnikDto.setAktivan(korisnik.getAktivan());
            trenerDtos.add(korisnikDto);
        }

        return new ResponseEntity<>(trenerDtos, HttpStatus.OK);
    }
    @DeleteMapping(value = "/deleteCoach", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus remove(@RequestBody List<Long> ids) throws Exception{
        for(Long id: ids) {
            Trener trener = trenerService.findOne(id);
            trenerService.delete(trener);
        }
        return HttpStatus.OK;
    }
}
