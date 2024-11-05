package com.example.stationdesky.controller;

import com.example.stationdesky.entities.Inscription;
import com.example.stationdesky.service.IGestionInscrit;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class InscritController {
    IGestionInscrit inscrit;

    @PostMapping("/addinscription/{num}")
    public Inscription addInscriptionAndAssignToSkieur(@RequestBody Inscription insc, @PathVariable("num") Long numSkieur){
        return inscrit.addInscriptionAndAssignToSkieur(insc,numSkieur);
    }

    @PutMapping("/assignToCours/{numinsc}/{numskieur}")
    public Inscription assignInscriptionToCours(@PathVariable("numinsc") Long numinsc,@PathVariable("numskieur") Long numSkieur){
        return inscrit.assignInscriptionToCours(numinsc,numSkieur);
    }

    @PostMapping("/addRegistrationAndAssignToSkierAndCourse/{numSkieur}/{numCours}")
    public ResponseEntity addRegistrationAndAssignToSkierAndCourse(@RequestBody Inscription inscription, @PathVariable("numSkieur") Long numSkieur, @PathVariable("numCours") Long numCours){
        Inscription result = inscrit.addRegistrationAndAssignToSkierAndCourse(inscription, numSkieur, numCours);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("La requête a échoué : le cours est complet ou les conditions ne sont pas remplies.");
        } else {
            return ResponseEntity.ok(result);
        }
    }

}
