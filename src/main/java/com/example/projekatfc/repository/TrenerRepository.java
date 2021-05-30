package com.example.projekatfc.repository;

import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.Trener;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrenerRepository extends JpaRepository<Trener, Long> {
    public Trener findTrenerByKorisnickoImeOrEmail(String param, String param2);
    public Boolean existsTrenerByKorisnickoImeOrEmail(String param, String param2);
}
