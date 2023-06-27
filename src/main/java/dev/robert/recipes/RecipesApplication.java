package dev.robert.recipes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class RecipesApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipesApplication.class, args);
	}

}
