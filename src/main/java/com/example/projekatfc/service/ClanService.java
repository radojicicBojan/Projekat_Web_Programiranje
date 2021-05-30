package com.example.projekatfc.service;


import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.DTO.LoginDto;
import com.example.projekatfc.repository.ClanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanService {
    @Autowired
    private ClanRepository clanRepository;

    public Clan registrujClana(KorisnikDto noviClan){
        Clan clan = new Clan();
        clan.setKorisnickoIme(noviClan.getKorisnickoIme());
        clan.setLozinka(noviClan.getLozinka());
        clan.setIme(noviClan.getIme());
        clan.setPrezime(noviClan.getPrezime());
        clan.setEmail(noviClan.getEmail());
        clan.setTelefon(noviClan.getTelefon());
        clan.setDatumRodjenja(noviClan.getDatumRodjenja());
        clan.setAktivan(noviClan.getAktivan());

        clanRepository.save(clan);
        return clan;
    }
    public Clan login(LoginDto clan){
        if(clanRepository.existsClanByKorisnickoImeOrEmail(clan.getKorisnickoImeEmail(), clan.getKorisnickoImeEmail())){
            Clan cl = clanRepository.findClanByKorisnickoImeOrEmail(clan.getKorisnickoImeEmail(), clan.getKorisnickoImeEmail());
            if(cl.getAktivan() && cl.getLozinka().equals(clan.getLozinka())){
                return cl;
            }
        } return null;
    }
}
