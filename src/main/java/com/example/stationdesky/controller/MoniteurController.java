package com.example.stationdesky.controller;

import com.example.stationdesky.entities.Moniteur;
import com.example.stationdesky.entities.Skieur;
import com.example.stationdesky.service.IGestionMoniteurs;
import com.example.stationdesky.service.IGestionSkieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/moniteurs")
public class MoniteurController {
    @Autowired
    IGestionMoniteurs moniteurs;
    @GetMapping("/getall")
    public List<Skieur> getAll(){
        return  moniteurs.retrieveAllMoniteurs();
    }
    @PostMapping("/addMoniteur")
    public Moniteur ajouterMoniteur(@RequestBody  Moniteur moniteur){
        return moniteurs.addMoniteur(moniteur);
    }
    @GetMapping("/getMoniteur/{id}")
    public Moniteur getSkiD(@PathVariable("id")long id){
        return moniteurs.retrieveMoniteur(id);
    }
    @DeleteMapping("/removeMoniteur/{id}")
    public String removeById(@PathVariable("id") long id) {
        moniteurs.removeMoniteur(id);
        return "moniteur avec l'ID " + id + " supprimé avec succès";
    }
    @PutMapping("/updateMoniteur/{id}")
    public Moniteur updateByid(@RequestBody Moniteur moniteur){
        return moniteurs.updateMoniteur(moniteur);
    }
    @PostMapping("/assigncours/{num}")
    public Moniteur addMoniteurAndAssigntoCours(@RequestBody Moniteur m,@PathVariable("num") Long numCours){
        return moniteurs.addMoniteurAndAssigntoCours(m,numCours);
    }

}
