package com.example.projekatfc.repository;

import com.example.projekatfc.model.Termin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface TerminRepository extends JpaRepository<Termin, Long> {
    List<Termin> findByCenaLessThanEqual(Double cena);
    List<Termin> findAllByVremePocetka(Date vremePocetka);
    List<Termin> findAllByOrderByCena();
    List<Termin> findAllByOrderByCenaDesc();
    List<Termin> findAllByOrderByVremePocetka();
    List<Termin> findAllByOrderByVremePocetkaDesc();

    Termin findOneById(Long id);

    Termin findOneByTreningId(Long id);
}
