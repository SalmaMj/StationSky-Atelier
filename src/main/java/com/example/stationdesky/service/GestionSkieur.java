package com.example.stationdesky.service;

import com.example.stationdesky.entities.*;
import com.example.stationdesky.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@AllArgsConstructor
@Service
public class GestionSkieur  implements IGestionSkieur{

    IPisteRepo pisteRepo;
    ISkieurRepo skieurRepo;
    ICoursRepo coursRepo;
    IAbonnementRepo abRepo;
    IInscritRepo inscRepo;

    @Override
    public List<Skieur> retrieveAllSkieur() {
        return skieurRepo.findAll();
    }




    @Override
    public Skieur addSkieur(Skieur skieur) {
        return skieurRepo.save(skieur);
    }

    @Override
    public Skieur updateSkieur(Skieur skieur) {
        return skieurRepo.save(skieur);
    }

    @Override
    public Skieur retrieveSkieur(Long numSkieur) {
        return skieurRepo.findById(numSkieur).orElse(null);
    }
    public void removeSkieur(Long numSkieur) {
        skieurRepo.deleteById(numSkieur);
    }

    @Override
    public Skieur addSkierAndAssignToCourse(Skieur ski, Long numCourse) {
        Abonnement ab=ski.getAbonnement();
        Cours cours=coursRepo.findById(numCourse).get();
        Inscription insc=new Inscription();

        insc.setCours(cours);
        insc.setSki(ski);

        skieurRepo.save(ski);
        inscRepo.save(insc);
        abRepo.save(ab);

        return ski;
    }



}
