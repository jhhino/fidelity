package com.hino.loyalty;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hino.loyalty.domain.Category;
import com.hino.loyalty.domain.Product;
import com.hino.loyalty.repository.CategoryRepository;
import com.hino.loyalty.repository.ProductRepository;

@SpringBootApplication
public class LoyaltyApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	
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
		
		Product p1 = new Product(null, "0123", "CKOne","Calvin Kein", BigDecimal.valueOf(100.00), fragrance);
		Product p2 = new Product(null, "0124", "Eternity","Calvin Kein", BigDecimal.valueOf(150.00), fragrance);
		Product p3 = new Product(null, "0125", "212","Carolina Herrera", BigDecimal.valueOf(120.00), fragrance);
		Product p4 = new Product(null, "0126", "Polo Red","Polo Ralph Lauren", BigDecimal.valueOf(130.00), fragrance);
		Product p5 = new Product(null, "0127", "Polo Blue","Polo Ralph Lauren", BigDecimal.valueOf(125.00), fragrance);
		Product p6 = new Product(null, "0128", "Polo Green","Polo Ralph Lauren", BigDecimal.valueOf(125.00), fragrance);
		Product p7 = new Product(null, "0129", "Polo Black","Polo Ralph Lauren", BigDecimal.valueOf(139.99), fragrance);
		Product p8 = new Product(null, "0130", "Rouge lip stick","M.A.C.", BigDecimal.valueOf(69.90), color);
		Product p9 = new Product(null, "0131", "Dark lips","M.A.C.", BigDecimal.valueOf(89.90), color);
		Product p10 = new Product(null, "0132", "Serum eye lift","Dermage", BigDecimal.valueOf(1199.99), skincare);
		productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9,p10));
		
//		fragrance.getProductList().addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
//		color.getProductList().addAll(Arrays.asList(p8,p9));
//		skincare.getProductList().addAll(Arrays.asList(p10));
	
		
		
		
	}

}
