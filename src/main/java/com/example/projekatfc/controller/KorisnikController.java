package com.example.projekatfc.controller;

import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.DTO.LoginDto;
import com.example.projekatfc.model.Korisnik;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.service.ClanService;
import com.example.projekatfc.service.TrenerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api")
public class KorisnikController {
    @Autowired
    private TrenerService trenerService;
    @Autowired
    private ClanService clanService;

    @PostMapping(value = "/registration")
    public ResponseEntity<KorisnikDto> registracija(@RequestBody KorisnikDto noviKorisnik){
        if(noviKorisnik.getUloga().equals("CLAN")){
            noviKorisnik.setAktivan(true);
            Clan clan = clanService.registrujClana(noviKorisnik);
            noviKorisnik.setId(clan.getId());
            return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
        }else{
            noviKorisnik.setAktivan(false);
            Trener trener = trenerService.registrujTrenera(noviKorisnik);
            noviKorisnik.setId(trener.getId());
            return new ResponseEntity<>(noviKorisnik, HttpStatus.CREATED);
        }
    }
    @PostMapping(value = "/login")
    public ResponseEntity<KorisnikDto> login(@RequestBody LoginDto potencijalniKorisnik){
        Clan c = clanService.login(potencijalniKorisnik);
        if(c!=null){
            KorisnikDto korisnik = new KorisnikDto();
            korisnik.setId(c.getId());
            korisnik.setKorisnickoIme(c.getKorisnickoIme());
            korisnik.setEmail(c.getEmail());
            korisnik.setDatumRodjenja(c.getDatumRodjenja());
            korisnik.setLozinka(c.getLozinka());
            korisnik.setIme(c.getIme());
            korisnik.setPrezime(c.getPrezime());
            korisnik.setTelefon(c.getTelefon());
            korisnik.setAktivan(c.getAktivan());

            return new ResponseEntity<>(korisnik, HttpStatus.OK);
        }
        Trener t = trenerService.login(potencijalniKorisnik);
        if(t!=null){
            KorisnikDto korisnik = new KorisnikDto();
            korisnik.setId(t.getId());
            korisnik.setKorisnickoIme(t.getKorisnickoIme());
            korisnik.setEmail(t.getEmail());
            korisnik.setDatumRodjenja(t.getDatumRodjenja());
            korisnik.setLozinka(t.getLozinka());
            korisnik.setIme(t.getIme());
            korisnik.setPrezime(t.getPrezime());
            korisnik.setTelefon(t.getTelefon());
            korisnik.setAktivan(t.getAktivan());

            return new ResponseEntity<>(korisnik, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
