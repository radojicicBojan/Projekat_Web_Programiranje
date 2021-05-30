package com.example.projekatfc.repository;

import com.example.projekatfc.model.OdradjenTrening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PrijavaRepository extends JpaRepository<OdradjenTrening, Long> {
}
