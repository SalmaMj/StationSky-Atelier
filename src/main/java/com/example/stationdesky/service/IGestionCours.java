package com.example.stationdesky.service;

import com.example.stationdesky.entities.Cours;

import java.util.List;

public interface IGestionCours {
    List retrieveAllCourses();
    Cours addCours(Cours cours);
    Cours updateCours (Cours cours);
    Cours retrieveCours (Long numCours);

    void removeCours(Long numCours);

}
