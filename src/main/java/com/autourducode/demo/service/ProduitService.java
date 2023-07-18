// mise en place de la couche service

package com.autourducode.demo.service;

import java.util.List;

import com.autourducode.demo.model.Produit;

public interface ProduitService {
    Produit creer(Produit produit);

    List<Produit> lire();

    Produit modifier(Long id, Produit produit);

    String supprimer(Long id); // prend l'id du produit à supprimer
}