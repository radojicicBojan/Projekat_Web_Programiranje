package com.example.projekatfc.service;

import com.example.projekatfc.model.DTO.SalaDto;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SalaService {
    @Autowired
    private SalaRepository salaRepository;

    public Sala dodajSalu(SalaDto novaSala){
        Sala sala = new Sala();
        sala.setKapacitet(novaSala.getKapacitet());
        sala.setOznaka(novaSala.getOznaka());

        salaRepository.save(sala);
        return sala;
    }
}
