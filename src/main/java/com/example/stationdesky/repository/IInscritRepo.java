package com.example.stationdesky.repository;

import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Inscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IInscritRepo extends JpaRepository<Inscription,Long> {

    @Query("SELECT COUNT(i) FROM Inscription i WHERE i.cours = :cours")
    int countByCours(@Param("cours") Cours cours);
}
