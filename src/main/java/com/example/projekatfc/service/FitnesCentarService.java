package com.example.projekatfc.service;

import com.example.projekatfc.model.DTO.FitnesCentarDto;
import com.example.projekatfc.model.FitnesCentar;
import com.example.projekatfc.repository.FitnesCentarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FitnesCentarService {
    @Autowired
    private FitnesCentarRepository fitnesCentarRepository;

    public FitnesCentar dodajFitnesCentar(FitnesCentarDto noviFitnesCentar){
        FitnesCentar fitnesCentar = new FitnesCentar();
        fitnesCentar.setNaziv(noviFitnesCentar.getNaziv());
        fitnesCentar.setEmail(noviFitnesCentar.getEmail());
        fitnesCentar.setTelefon(noviFitnesCentar.getTelefon());
        fitnesCentar.setAdresa(noviFitnesCentar.getAdresa());

        fitnesCentarRepository.save(fitnesCentar);
        return fitnesCentar;
    }
}
