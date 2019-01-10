package com.handy.tax.exercise.taxexercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = "com.handy.tax.exercise.taxexercise.repository")
@SpringBootApplication
public class TaxExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxExerciseApplication.class, args);
	}

}
