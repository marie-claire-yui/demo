package com.autourducode.demo.controller;

import com.autourducode.demo.model.Produit;
import com.autourducode.demo.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produit")
@AllArgsConstructor
public class ProduitController {
    private final ProduitService produitService;

    @PostMapping("/create")
    public Produit create(@RequestBody Produit produit){
        return produitService.creer(produit);
    }

    @GetMapping("/read")
    public List<Produit> read(){
        return produitService.lire();
    }

    // "sécurisation du end point protected"
    @GetMapping("/protected")
    public String helloSecure(){
        return "Hello Autour Du Code Protected !";
    }

    @GetMapping("/public")
    public String helloPublic(){
        return "Hello Autour Du Code Public !";
    }

     @GetMapping("/user")
    public String helloUser(){
        return "Hello Autour Du Code User !";
    }
    //"sécurisation"

    @PutMapping("/update/{id}") // ?name=autourducode login/AZE
    public Produit update(@PathVariable Long id,@RequestBody Produit produit){
        return produitService.modifier(id, produit);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id){
        return produitService.supprimer(id);
    }
}