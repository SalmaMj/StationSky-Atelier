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
public class Skieur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numSkieur;
    private String nomS;
    private String nomPrenom;
    private LocalDate dateNaissance;
    private String ville;
    @OneToOne(cascade = CascadeType.ALL)
    private Abonnement abonnement;
    @ManyToMany (mappedBy = "ski")
    private List<Piste> piste;
    @OneToMany(mappedBy = "ski")
    private List<Inscription> inscrit;



}
