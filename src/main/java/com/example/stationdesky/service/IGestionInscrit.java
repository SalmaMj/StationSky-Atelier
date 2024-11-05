package com.example.stationdesky.service;

import com.example.stationdesky.entities.Inscription;

public interface IGestionInscrit {
    Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur);

    Inscription assignInscriptionToCours(Long numInsc, Long numCours);

    Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours);
}
