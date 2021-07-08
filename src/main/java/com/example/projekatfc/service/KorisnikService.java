package com.example.projekatfc.service;

import com.example.projekatfc.model.Korisnik;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.repository.KorisnikRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KorisnikService {
    @Autowired
    private KorisnikRepository korisnikRepository;

    public Korisnik findOne(Long id) {
        Korisnik korisnik = this.korisnikRepository.getOne(id);
        return korisnik;
    }

    public List<Korisnik> findAll(){
        List<Korisnik> korisnici = this.korisnikRepository.findAll();
        return korisnici;
    }

        public Korisnik create (Korisnik korisnik) throws Exception {
            if (korisnik.getId() != null) {
                throw new Exception("ID must be null!");
            }
            Korisnik noviKorisnik = this.korisnikRepository.save(korisnik);
            return noviKorisnik;
        }

        public void delete (Long id){
            this.korisnikRepository.deleteById(id);
        }

    public void save(Korisnik korisnik) {
        this.korisnikRepository.save(korisnik);
    }
}

