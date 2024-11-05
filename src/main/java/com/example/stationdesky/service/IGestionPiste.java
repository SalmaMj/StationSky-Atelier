package com.example.stationdesky.service;

import com.example.stationdesky.entities.Piste;

import java.util.List;

public interface IGestionPiste {

    public List<Piste> retrieveAllPistes();
    Piste addPiste(Piste piste);
    Piste updatePiste (Piste piste);
    Piste retrievePiste (Long numPiste);

    void removePiste(Long numPiste) ;

}
