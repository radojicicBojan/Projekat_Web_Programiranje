package com.example.projekatfc.repository;

import com.example.projekatfc.model.OdradjenTrening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OdradjenTreningRepository extends JpaRepository<OdradjenTrening, Long> {
    OdradjenTrening findByClan_IdAndTermin_Id(Long clan_id, Long termin_id);

}
