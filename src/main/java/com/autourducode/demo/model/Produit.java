package com.autourducode.demo.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
// annotation pour que cette classe puisse être mapper avec une base de données
@Table(name = "PRODUIT")
@Getter //lombok pour générer les getters
@Setter // lombok pour générer les setters
@NoArgsConstructor // lombok pour générer constructeur sans arguments
public class Produit {
    @Id // mapper l'identifiant 
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mode de génération de clé primaire
    private Long id;
    @Column(length = 50)
    private String nom; // ajout d'une chaine de caractère pour le nom du produit
    @Column(length = 150)
    private String description; //du produit
    private Integer prix; // du produit
}