package com.example.projekatfc.service;

import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.DTO.LoginDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.repository.TrenerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrenerService {
    @Autowired
    private TrenerRepository trenerRepository;
    @Autowired
    private FitnesCentarService fitnesCentarService;

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
        FitnesCentar fitnesCentar = fitnesCentarService.findOne(noviTrener.getFitnesCentarId());
        trener.setFitnesCentar(fitnesCentar);

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
    public List<Trener> getAll(){
        return trenerRepository.findAll();
    }

    public List<Trener> getAllUnactive(){
        return trenerRepository.getAllByAktivan(false);
    }

    public Trener update(Trener trener) throws Exception {
        Trener savedEm = this.trenerRepository.save(trener);
        return savedEm;
    }
    public Trener findOne(Long id) {
        Trener trener = this.trenerRepository.getOne(id);
        return trener;
    }
    public void delete(Trener trener){
        trenerRepository.deleteById(trener.getId());
    }
}
