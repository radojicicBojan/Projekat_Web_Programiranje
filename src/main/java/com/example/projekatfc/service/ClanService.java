package com.example.projekatfc.service;


import com.example.projekatfc.model.Clan;
import com.example.projekatfc.model.DTO.KorisnikDto;
import com.example.projekatfc.model.DTO.LoginDto;
import com.example.projekatfc.model.RezervisanTrening;
import com.example.projekatfc.model.Termin;
import com.example.projekatfc.repository.ClanRepository;
import com.example.projekatfc.repository.RezervisanTreningRepository;
import com.example.projekatfc.repository.TerminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClanService {
    @Autowired
    private ClanRepository clanRepository;
    @Autowired
    private RezervisanTreningRepository rezervisanTreningRepository;
    @Autowired
    private TerminRepository terminRepository;

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
    public Clan findOneById(Long id){
        Clan clan = this.clanRepository.findOneById(id);
        return clan;
    }
    public boolean prijavaZaTermin(Clan clan, Termin termin){
        if(rezervisanTreningRepository.existsByClan_IdAndTermin_Id(clan.getId(), termin.getId())){
            return false;
        }
        RezervisanTrening rz = new RezervisanTrening();
        rz.setClan(clan);
        rz.setTermin(termin);
        termin.setBrojPrijavljenihClanova(termin.getBrojPrijavljenihClanova()+1);
        terminRepository.save(termin);

        rezervisanTreningRepository.save(rz);
        return true;
    }

    public boolean otkazivanjePrijaveZaTermin(Clan clan, Termin termin) {
        if(rezervisanTreningRepository.existsByClan_IdAndTermin_Id(clan.getId(), termin.getId())){
            return false;
        }

        termin.setBrojPrijavljenihClanova(termin.getBrojPrijavljenihClanova()-1);
        terminRepository.save(termin);

        rezervisanTreningRepository.deleteByClan_IdAndTermin_Id(clan.getId(), termin.getId());
        return true;
    }
}
