package com.example.stationdesky.service;

import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Moniteur;
import com.example.stationdesky.repository.ICoursRepo;
import com.example.stationdesky.repository.IMoniteurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GestionMoniteurs implements IGestionMoniteurs{

    @Autowired
    private IMoniteurRepo moniteurRepo;
    @Autowired
    private ICoursRepo coursRepo;
    @Override
    public List retrieveAllMoniteurs() {
        return moniteurRepo.findAll();
    }

    @Override
    public Moniteur addMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur updateMoniteur(Moniteur moniteur) {
        return moniteurRepo.save(moniteur);
    }

    @Override
    public Moniteur retrieveMoniteur(Long numMoniteur) {
        return moniteurRepo.findById(numMoniteur).orElse(null);
    }

    @Override
    public void removeMoniteur(Long numMoniteur) {
        moniteurRepo.deleteById(numMoniteur);
    }

    @Override
    public Moniteur addMoniteurAndAssigntoCours(Moniteur m, Long numCours) {
        Cours cours=coursRepo.findById(numCours).get();
        m.getCours().add(cours);
        return moniteurRepo.save(m);
    }
}
