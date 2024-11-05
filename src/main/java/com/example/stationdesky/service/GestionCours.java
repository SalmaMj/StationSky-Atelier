package com.example.stationdesky.service;

import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.repository.ICoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionCours implements IGestionCours{

    @Autowired
    private ICoursRepo coursRepo;
    @Override
    public List retrieveAllCourses() {
        return coursRepo.findAll();
    }

    @Override
    public Cours addCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours updateCours(Cours cours) {
        return coursRepo.save(cours);
    }

    @Override
    public Cours retrieveCours(Long numCours) {
        return coursRepo.findById(numCours).orElse(null);
    }

    @Override
    public void removeCours(Long numCours) {
        coursRepo.deleteById(numCours);
    }
}
