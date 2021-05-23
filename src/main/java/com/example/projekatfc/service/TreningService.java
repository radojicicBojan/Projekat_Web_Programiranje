package com.example.projekatfc.service;

import com.example.projekatfc.model.Trening;
import com.example.projekatfc.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TreningService {
    @Autowired
    private TreningRepository treningRepository;

    public Trening findOne(Long id){
        return this.treningRepository.getOne(id);

    }
    public List<Trening> findAll(){
        return this.treningRepository.findAll();
    }
    public Trening save(Trening trening){return this.treningRepository.save(trening);}
}
