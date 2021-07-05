package com.example.projekatfc.service;

import com.example.projekatfc.model.Administrator;

import com.example.projekatfc.model.DTO.LoginDto;
import com.example.projekatfc.repository.AdministratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdministratorService {
    @Autowired
    private AdministratorRepository administratorRepository;


    public Administrator login(LoginDto administrator){
        if(administratorRepository.existsAdministratorByKorisnickoImeOrEmail(administrator.getKorisnickoImeEmail(), administrator.getKorisnickoImeEmail())){
            Administrator admin = administratorRepository.findAdministratorByKorisnickoImeOrEmail(administrator.getKorisnickoImeEmail(), administrator.getKorisnickoImeEmail());
            if(admin.getAktivan() && admin.getLozinka().equals(administrator.getLozinka())){
                return admin;
            }
        } return null;
    }
}
