package com.autourducode.demo.repository; //DAO

import org.springframework.data.jpa.repository.JpaRepository;

import com.autourducode.demo.model.Produit;

public interface ProduitRepository extends JpaRepository<Produit, Long> {
    
}
