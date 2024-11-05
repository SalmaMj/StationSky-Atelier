package com.example.stationdesky.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Abonnement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long numAbon;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixAbon;
    @Enumerated(EnumType.STRING)
    private Type_Abonnement typeAbon;



}
