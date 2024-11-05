package com.example.stationdesky.controller;

import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Skieur;
import com.example.stationdesky.service.IGestionCours;
import com.example.stationdesky.service.IGestionSkieur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cours")
public class CoursController {
    @Autowired
    IGestionCours cours;
    @GetMapping("/getall")
    public List<Cours> getAll(){
        return  cours.retrieveAllCourses();
    }
    @PostMapping("/addcours")
    public Cours ajouterCours(@RequestBody Cours course){
        return cours.addCours(course);
    }
    @GetMapping("/getcours/{id}")
    public Cours getSkiD(@PathVariable("id")long id){
        return cours.retrieveCours(id);
    }
    @DeleteMapping("/removecours/{id}")
    public String removeById(@PathVariable("id") long id) {
        cours.removeCours(id);
        return "Cours avec l'ID " + id + " supprimé avec succès";
    }
    @PutMapping("/updatecours/{id}")
    public Cours updateByid(@RequestBody Cours course){
        return cours.updateCours(course);
    }

}
