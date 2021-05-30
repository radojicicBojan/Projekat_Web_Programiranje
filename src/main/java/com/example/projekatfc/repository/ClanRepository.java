package com.example.projekatfc.repository;

import com.example.projekatfc.model.Clan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClanRepository extends JpaRepository<Clan, Long> {
    public Clan findClanByKorisnickoImeOrEmail(String param, String param2);
    public Boolean existsClanByKorisnickoImeOrEmail(String param, String param2);
}
