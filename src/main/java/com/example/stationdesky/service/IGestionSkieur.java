package com.example.stationdesky.service;

import com.example.stationdesky.entities.Piste;
import com.example.stationdesky.entities.Skieur;

import java.util.List;

public interface IGestionSkieur {
    List<Skieur> retrieveAllSkieur();
    public Skieur addSkieur(Skieur skieur);
    Skieur updateSkieur (Skieur skieur);
    Skieur retrieveSkieur (Long numSkieur);
   void removeSkieur(Long numSkieur);

    Skieur addSkierAndAssignToCourse(Skieur ski, Long numCourse);
}
