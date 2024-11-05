package com.example.stationdesky.service;

import com.example.stationdesky.entities.Abonnement;
import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Moniteur;
import com.example.stationdesky.repository.IAbonnementRepo;
import com.example.stationdesky.repository.ICoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionAbonnement implements IGestionAbonnemnt{

    @Autowired
    private IAbonnementRepo abonnementRepo;
    @Override
    public List retrieveAllAbonnemnts() {
        return abonnementRepo.findAll();
    }

    @Override
    public Abonnement addAbonnemnt(Abonnement abn) {
        return abonnementRepo.save(abn);
    }

    @Override
    public Abonnement updateAbonnemnt(Abonnement abn) {
        return abonnementRepo.save(abn);
    }

    @Override
    public Abonnement retrieveAbonnemnt(Long numAbon) {
        return abonnementRepo.findById(numAbon).orElse(null);
    }

    @Override
    public void removeAbonnemnt(Long numAbon) {
        abonnementRepo.deleteById(numAbon);
    }
}
