package com.example.projekatfc.repository;

import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.Korisnik;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KorisnikRepository extends JpaRepository<Korisnik, Long> {
    public Korisnik findKorisnikByKorisnickoImeOrEmail(String param, String param2);
    public Boolean existsClanByKorisnickoImeOrEmail(String param, String param2);
}
