package com.example.stationdesky.controller;

import com.example.stationdesky.entities.Abonnement;
import com.example.stationdesky.entities.Skieur;
import com.example.stationdesky.service.IGestionAbonnemnt;
import com.example.stationdesky.service.IGestionSkieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/abonnements")
public class AbonnementController {
    @Autowired
    IGestionAbonnemnt abonnement;
    @GetMapping("/getall")
    public List<Abonnement> getAll(){
        return  abonnement.retrieveAllAbonnemnts();
    }
    @PostMapping("/addAbn")
    public Abonnement ajouterSkieur(@RequestBody Abonnement ab){
        return abonnement.addAbonnemnt(ab);
    }
    @GetMapping("/getAbn/{id}")
    public Abonnement getSkiD(@PathVariable("id")long id){
        return abonnement.retrieveAbonnemnt(id);
    }
    @DeleteMapping("/removeAbn/{id}")
    public String removeById(@PathVariable("id") long id) {
        abonnement.removeAbonnemnt(id);
        return "Abonnement avec l'ID " + id + " supprimé avec succès";
    }
    @PutMapping("/updateAbn/{id}")
    public Abonnement updateByid(@RequestBody Abonnement ab){
        return abonnement.updateAbonnemnt(ab);
    }

}
