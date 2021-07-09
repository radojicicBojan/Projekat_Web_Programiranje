package com.example.projekatfc.repository;

import com.example.projekatfc.model.RezervisanTrening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RezervisanTreningRepository extends JpaRepository<RezervisanTrening, Long> {
    Boolean existsByClan_IdAndTermin_Id(Long clan_id, Long termin_id);
    RezervisanTrening findByClan_IdAndTermin_Id(Long clan_id, Long termin_id);
}
