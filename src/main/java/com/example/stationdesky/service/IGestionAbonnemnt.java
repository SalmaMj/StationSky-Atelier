package com.example.stationdesky.service;

import com.example.stationdesky.entities.Abonnement;
import com.example.stationdesky.entities.Moniteur;

import java.util.List;

public interface IGestionAbonnemnt {

    List retrieveAllAbonnemnts();
    Abonnement addAbonnemnt(Abonnement abn);
    Abonnement updateAbonnemnt (Abonnement abn);
    Abonnement retrieveAbonnemnt (Long numAbon);
    void removeAbonnemnt(Long numAbon) ;

}
