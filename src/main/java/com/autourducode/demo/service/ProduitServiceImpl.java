// implémentation du produit service
package com.autourducode.demo.service;

import com.autourducode.demo.model.Produit;
import com.autourducode.demo.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // cette classe contient du code métier
@AllArgsConstructor // demande à lombock d'utiliser tous les champs pour le constructeur (annotation qui permet de générer un constructeur)
public class ProduitServiceImpl implements ProduitService {

    private final ProduitRepository produitRepository;

    @Override
    public Produit creer(Produit produit){
        return produitRepository.save(produit); // pour persister ou enregistrer notre produit
    }

    @Override
    public List<Produit> lire() {

        return produitRepository.findAll();
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id)
        .map(p -> {
           p.setPrix(p.getPrix());
           p.setNom(produit.getNom());
           p.setDescription(produit.getDescription());
           return produitRepository.save(p);
        }).orElseThrow(() -> new RuntimeException(("Produit non trouvé"))); // récuparation du produit si on trouve notre produit
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id);
        return "Produit supprimé";
    }
    
}
