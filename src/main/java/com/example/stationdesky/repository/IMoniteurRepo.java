package com.example.stationdesky.repository;

import com.example.stationdesky.entities.Moniteur;
import com.example.stationdesky.entities.Support;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IMoniteurRepo extends JpaRepository<Moniteur,Long> {


    @Query("SELECT DISTINCT i.numSemaine " +
            "FROM Moniteur m " +
            "JOIN m.cours c " +
            "JOIN c.inscrit i " +
            "WHERE m.numMoniteur = :numMoniteur AND c.support = :support " +
            "ORDER BY i.numSemaine")
    List<Integer> listerNumerosSemainesParMoniteurEtSupport(
            @Param("numMoniteur") long numMoniteur,
            @Param("support") Support support
    );







}
