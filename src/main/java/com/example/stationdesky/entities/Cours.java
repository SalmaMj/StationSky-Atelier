package com.example.stationdesky.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cours implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numCours;
    private int niveau;
    @Enumerated(EnumType.STRING)
    private Type_Cours typeCours;
    private Support support;
    private Float prix;
    private int creneau;
    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscrit;



}
