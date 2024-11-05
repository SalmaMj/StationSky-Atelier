package com.example.stationdesky.service;

import com.example.stationdesky.entities.Piste;
import com.example.stationdesky.repository.IPisteRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionPiste implements IGestionPiste{

    @Autowired
    IPisteRepo pisteRepo;

    @Override
    public List<Piste> retrieveAllPistes() {
        return pisteRepo.findAll();
    }


    @Override
    public Piste addPiste(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public Piste updatePiste(Piste piste) {
        return pisteRepo.save(piste);
    }

    @Override
    public Piste retrievePiste(Long numPiste) {
        return pisteRepo.findById(numPiste).orElse(null);
    }

    @Override
    public void removePiste(Long numPiste) {
        pisteRepo.deleteById(numPiste);
    }

}
