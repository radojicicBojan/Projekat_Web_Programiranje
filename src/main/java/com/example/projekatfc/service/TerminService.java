package com.example.projekatfc.service;

import com.example.projekatfc.model.DTO.TerminTreningDto;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.model.Termin;
import com.example.projekatfc.model.Trener;
import com.example.projekatfc.model.Trening;
import com.example.projekatfc.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class TerminService {
    @Autowired
    private TerminRepository terminRepository;

    public TerminService(TerminRepository terminRepository) {
        this.terminRepository = terminRepository;
    }
    public List<Termin> findAll() {
        List<Termin> termin = this.terminRepository.findAll();
        return termin;
    }
    public List<Termin> findAllByVremePocetka(Date vremePocetka) {
        List<Termin> termin = this.terminRepository.findAllByVremePocetka(vremePocetka);
        return termin;
    }
    public List<Termin> findByCenaLessThanEqual(Double cena) {
        List<Termin> termin = this.terminRepository.findByCenaLessThanEqual(cena);
        return termin;
    }
    public List<Termin> findAllByOrderByCena() {
        List<Termin> termin = this.terminRepository.findAllByOrderByCena();
        return termin;
    }
    public List<Termin> findAllByOrderByCenaDesc() {
        List<Termin> termin = this.terminRepository.findAllByOrderByCenaDesc();
        return termin;
    }

    public List<Termin> findAllByOrderByVremePocetka() {
    List<Termin> termin = this.terminRepository.findAllByOrderByVremePocetka();
    return termin;
    }
    public List<Termin> findAllByOrderByVremePocetkaDesc() {
        List<Termin> termin = this.terminRepository.findAllByOrderByVremePocetkaDesc();
        return termin;
    }
    public Termin save(Termin termin){return this.terminRepository.save(termin);}

    public Termin findOne(Long id){
        Termin termin = this.terminRepository.findOneById(id);
        return termin;
    }
    public Termin findOneByTreningId(Long id){
        Termin termin = this.terminRepository.findOneByTreningId(id);
        return termin;
    }

    public Termin findOneById(Long id) {
        Termin termin = this.terminRepository.findOneById(id);
        return termin;
    }

    public Termin update(Termin termin) {
        Termin saved = this.terminRepository.save(termin);
        return saved;

    }

    public Termin addTermin(TerminTreningDto novTermin, Trening trening, Sala sala) {
        Termin termin = new Termin();

        termin.setTrening(trening);
        termin.setCena(novTermin.getCena());
        termin.setVremePocetka(novTermin.getVremePocetka());
        termin.setBrojPrijavljenihClanova(0);
        termin.setSala(sala);


        terminRepository.save(termin);


        return termin;


    }
}
