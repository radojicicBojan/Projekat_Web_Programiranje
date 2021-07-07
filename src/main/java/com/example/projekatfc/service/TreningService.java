package com.example.projekatfc.service;

import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.DTO.TreningDto;
import com.example.projekatfc.model.DTO.TreningTrenerDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.model.Termin;
import com.example.projekatfc.model.Trening;
import com.example.projekatfc.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.util.List;

@Service
public class TreningService {
    @Autowired
    private TreningRepository treningRepository;

    public Trening findOne(Long id){

        return this.treningRepository.findOneById(id);
    }
    public Trening dodajTreningTrener(TreningTrenerDto noviTrening){
        Trening trening = new Trening();
        trening.setNaziv(noviTrening.getNaziv());
        trening.setOpis(noviTrening.getOpis());
        trening.setTipTreninga(noviTrening.getTipTreninga());
        trening.setTrajanje(noviTrening.getTrajanje());
        trening.getTrener().setId(noviTrening.getTrenerId());

        treningRepository.save(trening);
        return trening;
    }

    public Trening dodajTrening(TreningDto noviTrening){
        Trening trening = new Trening();
        trening.setNaziv(noviTrening.getNaziv());
        trening.setOpis(noviTrening.getOpis());
        trening.setTipTreninga(noviTrening.getTipTreninga());
        trening.setTrajanje(noviTrening.getTrajanje());

        treningRepository.save(trening);
        return trening;
    }

    public List<Trening> findAll(){
        List<Trening> treninzi = this.treningRepository.findAll();
        return treninzi;
    }

    public List<Trening> findAllByTrenerId(Long id){
        List<Trening> treninzi = this.treningRepository.findAllByTrenerId(id);
        return treninzi;
    }

    public List<Trening> findAllByNazivContaining(String naziv){
        List<Trening> treninzi = this.treningRepository.findAllByNazivContaining(naziv);
        return treninzi;
    }

    public List<Trening> findAllByOpisContaining(String opis){
        List<Trening> treninzi = this.treningRepository.findAllByOpisContaining(opis);
        return treninzi;
    }

    public List<Trening> findAllByTipTreningaContaining(String tipTreninga){
        List<Trening> treninzi = this.treningRepository.findAllByTipTreningaContaining(tipTreninga);
        return treninzi;
    }

    public List<Trening> findAllByTerminCena(double cena){
        List<Trening> treninzi = this.treningRepository.findAllByTerminiCena(cena);
        return treninzi;
    }

    public Trening findOneByTerminiId(Long id){
        Trening trening = this.treningRepository.findOneByTerminiId(id);
        return trening;
    }


    public Trening save(Trening trening){return this.treningRepository.save(trening);}
}
