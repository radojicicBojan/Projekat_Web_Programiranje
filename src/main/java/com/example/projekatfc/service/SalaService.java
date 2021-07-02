package com.example.projekatfc.service;

import com.example.projekatfc.model.DTO.SalaDto;
import com.example.projekatfc.model.Sala;
import com.example.projekatfc.repository.SalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public List<Sala> getAll(){
        return salaRepository.findAll();
    }
    public void delete(Sala sala){
        salaRepository.deleteById(sala.getId());
    }
    public Sala findOne(Long id) {
        Sala sala = this.salaRepository.getOne(id);
        return sala;
    }
}
