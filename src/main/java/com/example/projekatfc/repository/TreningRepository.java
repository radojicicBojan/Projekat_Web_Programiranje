package com.example.projekatfc.repository;

import com.example.projekatfc.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    List<Trening> findByNaziv(String naziv);
    List<Trening> findByOpis(String opis);
    List<Trening> findByTipTreninga(String tipTreninga);
    List<Trening> findByTrajanje(Integer trajanje);
    List<Trening> findByTrenerIme(String trenerIme);
    List<Trening> findByNazivOrderByNaziv(String naziv);




}
