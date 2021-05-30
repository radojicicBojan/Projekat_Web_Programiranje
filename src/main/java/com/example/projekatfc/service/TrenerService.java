package com.example.projekatfc.service;

import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.DTO.LoginDto;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrenerService {
    @Autowired
    private TrenerRepository trenerRepository;
    public Trener registrujTrenera(KorisnikDto noviTrener){
        Trener trener = new Trener();
        trener.setKorisnickoIme(noviTrener.getKorisnickoIme());
        trener.setLozinka(noviTrener.getLozinka());
        trener.setIme(noviTrener.getIme());
        trener.setPrezime(noviTrener.getPrezime());
        trener.setEmail(noviTrener.getEmail());
        trener.setTelefon(noviTrener.getTelefon());
        trener.setDatumRodjenja(noviTrener.getDatumRodjenja());
        trener.setAktivan(noviTrener.getAktivan());

        trenerRepository.save(trener);
        return trener;
    }
    public Trener login(LoginDto trener){
        if(trenerRepository.existsTrenerByKorisnickoImeOrEmail(trener.getKorisnickoImeEmail(), trener.getKorisnickoImeEmail())){
            Trener tr = trenerRepository.findTrenerByKorisnickoImeOrEmail(trener.getKorisnickoImeEmail(), trener.getKorisnickoImeEmail());
            if(tr.getAktivan() && tr.getLozinka().equals(trener.getLozinka())){
                return tr;
            }
        } return null;
    }
}
