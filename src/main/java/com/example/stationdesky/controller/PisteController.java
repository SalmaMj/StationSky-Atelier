package com.example.stationdesky.controller;

import com.example.stationdesky.entities.Abonnement;
import com.example.stationdesky.entities.Piste;
import com.example.stationdesky.entities.Skieur;
import com.example.stationdesky.service.IGestionPiste;
import com.example.stationdesky.service.IGestionSkieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pistes")
public class PisteController {
    @Autowired
    IGestionPiste piste;
    @GetMapping("/getall")
    public List<Piste> getAll(){
        return  piste.retrieveAllPistes();
    }
    @PostMapping("/addPiste")
    public Piste ajouterPiste(@RequestBody Piste pis){
        return piste.addPiste(pis);
    }
    @GetMapping("/getPiste/{id}")
    public Piste getPisteiD(@PathVariable("id")long id){
        return piste.retrievePiste(id);
    }
    @DeleteMapping("/removePiste/{id}")
    public String removeById(@PathVariable("id") long id) {
        piste.removePiste(id);
        return "Piste avec l'ID " + id + " supprimé avec succès";
    }
    @PutMapping("/updatePiste/{id}")
    public Piste updateByid(@RequestBody Piste pis){
         return piste.updatePiste(pis);
    }

}
