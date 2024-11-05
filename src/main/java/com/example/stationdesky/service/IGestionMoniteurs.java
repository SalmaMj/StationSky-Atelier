package com.example.stationdesky.service;

import com.example.stationdesky.entities.Moniteur;

import java.util.List;

public interface IGestionMoniteurs {

    List retrieveAllMoniteurs();
    Moniteur addMoniteur(Moniteur moniteur);
    Moniteur updateMoniteur (Moniteur moniteur);
    Moniteur retrieveMoniteur (Long numMoniteur);
    void removeMoniteur(Long numMoniteur) ;

    Moniteur addMoniteurAndAssigntoCours(Moniteur m, Long numCours);
}
