package com.example.stationdesky.repository;

import com.example.stationdesky.entities.Abonnement;
import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Type_Abonnement;
import com.example.stationdesky.entities.Type_Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface IAbonnementRepo extends JpaRepository<Abonnement,Long> {

    @Query("SELECT a FROM Abonnement a WHERE a.typeAbon = :tyA ORDER BY a.dateDebut")
    public List<Abonnement> listerAbonnementParTypeEtTri(@Param("tyA") Type_Abonnement tya);

    @Query("SELECT a FROM Abonnement a WHERE a.dateDebut BETWEEN :startDate AND :endDate ORDER BY a.dateDebut")
    public List<Abonnement> listerAbonnementsEntreDeuxDates(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate dateFin);



}
