package com.hino.loyalty;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.repository.CategoryRepository;

@SpringBootApplication
public class LoyaltyApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(LoyaltyApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Category fragrance = new Category(null,"Fragrance","Category related to any fragrance product.");
		Category color = new Category(null,"Color","Category related to any color product.");
		Category skincare = new Category(null,"Skincare","Category related to any skincare product.");
		Category hair = new Category(null,"Hair","Category related to any hair product.");
		
		categoryRepository.saveAll(Arrays.asList(fragrance, color, skincare, hair));
	}

}
