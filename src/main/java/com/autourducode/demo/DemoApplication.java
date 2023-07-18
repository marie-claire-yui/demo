package com.autourducode.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // notation qui identifie cette classe comme étant une application
// springboot donc introduit l'autoconfiguration de notre application
public class DemoApplication { //génération d'une class par defaut de notre application 

	public static void main(String[] args) { // méthode main: méthode principale méthode d'entrée de notre application
		SpringApplication.run(DemoApplication.class, args);
	}

}
