package com.example.stationdesky.repository;

import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Type_Cours;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ICoursRepo extends JpaRepository<Cours,Long> {

    @Query("select c from Cours c where c.typeCours = :tyC and c.niveau = :niveau")
    List<Cours> listerCours(@Param("tyC") Type_Cours tyC, @Param("niveau") int niveau);


}
