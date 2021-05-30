package com.example.projekatfc;

import com.example.projekatfc.model.Trening;
import com.example.projekatfc.repository.TreningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class ProjekatFcApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjekatFcApplication.class, args);
	}

}
