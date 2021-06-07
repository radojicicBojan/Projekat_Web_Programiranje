package com.example.projekatfc.service;

import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.DTO.TreningDto;
import com.example.projekatfc.model.FitnesCentar;
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
        return this.treningRepository.getOne(id);
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
        return this.treningRepository.findAll();
    }
    public Trening save(Trening trening){return this.treningRepository.save(trening);}
}
