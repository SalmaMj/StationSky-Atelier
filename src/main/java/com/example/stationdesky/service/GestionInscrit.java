package com.example.stationdesky.service;

import com.example.stationdesky.entities.Cours;
import com.example.stationdesky.entities.Inscription;
import com.example.stationdesky.entities.Skieur;
import com.example.stationdesky.entities.Type_Cours;
import com.example.stationdesky.repository.ICoursRepo;
import com.example.stationdesky.repository.IInscritRepo;
import com.example.stationdesky.repository.ISkieurRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
@Service
public class GestionInscrit implements IGestionInscrit {
   @Autowired
    ISkieurRepo skieurRepo;
   @Autowired
    IInscritRepo inscRepo;
   @Autowired
    ICoursRepo coursRepo;
    @Override
    public Inscription addInscriptionAndAssignToSkieur(Inscription inscription, Long numSkieur) {
        Skieur skieur=skieurRepo.findById(numSkieur).get();
        // skieur.getInscription().add(inscription);
        inscription.setSki(skieur);
        return inscRepo.save(inscription);
    }

    @Override
    public Inscription assignInscriptionToCours(Long numInsc, Long numCours) {
        Cours cours=coursRepo.findById(numCours).get();
        Inscription insc=inscRepo.findById(numInsc).get();

        insc.setCours(cours);
        return inscRepo.save(insc);
    }

    @Override
    public Inscription addRegistrationAndAssignToSkierAndCourse(Inscription inscription, Long numSkieur, Long numCours) {
        Cours c =coursRepo.findById(numCours).get();
        Skieur sk=skieurRepo.findById(numSkieur).get();

        if(c.getTypeCours() == Type_Cours.COLLECTIF_ADULTE.COLLECTIF_ENFANT || c.getTypeCours() == Type_Cours.COLLECTIF_ADULTE) {
            int nb = inscRepo.countByCours(c);
            if (nb >= 6)
                return null; //throw new IllegalStateException("The course is already full");
            else {
                int age = Period.between(sk.getDateNaissance(), LocalDate.now()).getYears();// Vérifier si le skieur est mineur ou adulte
                if ((age >= 18 && c.getTypeCours() == Type_Cours.COLLECTIF_ENFANT) || (age < 18 && c.getTypeCours() == Type_Cours.COLLECTIF_ADULTE))
                    return null;
            }
        }

        inscription.setCours(c);
        inscription.setSki(sk);

        return inscRepo.save(inscription);
    }
}
