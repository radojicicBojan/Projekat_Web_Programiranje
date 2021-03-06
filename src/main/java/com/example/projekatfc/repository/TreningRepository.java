package com.example.projekatfc.repository;

import com.example.projekatfc.model.Termin;
import com.example.projekatfc.model.Trening;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TreningRepository extends JpaRepository<Trening, Long> {
    List<Trening> findAllByNazivContaining(String naziv);
    List<Trening> findAllByOpisContaining(String opis);
    List<Trening> findAllByTipTreningaContaining(String tipTreninga);
    List<Trening> findAllByTerminiCena(double cena);
    List<Trening> findAllByTrenerId(Long id);

    Trening findOneById(Long id);


    Trening findByTermini(Termin termin);
}
