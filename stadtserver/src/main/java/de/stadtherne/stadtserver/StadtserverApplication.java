package de.stadtherne.stadtserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StadtserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(StadtserverApplication.class, args);
		System.out.println("Projekt: " + StadtserverApplication.class.getSimpleName());
		System.out.println("Testing Git");
	}

}
