package com.example.projekatfc;

import com.example.projekatfc.model.Trening;
import com.example.projekatfc.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjekatFcApplication {
	@Autowired
	private TreningRepository treningRepository;


	public void run(String... args){
		Trening trening = new Trening();
		trening.setNaziv("Biceps");
		trening.setOpis("Treing za biceps");

		this.treningRepository.save(trening);

		List<Trening> treninzi = this.treningRepository.findByTipTreninga("Teretana");
		for(Trening t : treninzi){
			System.out.println(t);
		}
	}
	public static void main(String[] args) {
		SpringApplication.run(ProjekatFcApplication.class, args);
	}

}
