package com.example.projekatfc.repository;

import com.example.projekatfc.model.Administrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdministratorRepository extends JpaRepository<Administrator, Long> {
    public Administrator findAdministratorByKorisnickoImeOrEmail(String param, String param2);
    public Boolean existsAdministratorByKorisnickoImeOrEmail(String param, String param2);
}
