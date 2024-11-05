package com.example.stationdesky.repository;

import com.example.stationdesky.entities.Moniteur;
import com.example.stationdesky.entities.Piste;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPisteRepo extends JpaRepository<Piste,Long> {

}
