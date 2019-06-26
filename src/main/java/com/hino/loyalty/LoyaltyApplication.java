package com.hino.loyalty;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hino.loyalty.domain.Address;
import com.hino.loyalty.domain.Category;
import com.hino.loyalty.domain.City;
import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.domain.Product;
import com.hino.loyalty.domain.State;
import com.hino.loyalty.domain.enums.Tier;
import com.hino.loyalty.repository.AddressRepository;
import com.hino.loyalty.repository.CategoryRepository;
import com.hino.loyalty.repository.CityRepository;
import com.hino.loyalty.repository.CustomerRepository;
import com.hino.loyalty.repository.ProductRepository;
import com.hino.loyalty.repository.StateRepository;

@SpringBootApplication
public class LoyaltyApplication implements CommandLineRunner {

	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private StateRepository stateRepository;
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private AddressRepository addressRepository;
	
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
		
		State sp = new State(null,"São Paulo","SP",null);
		State mg = new State(null,"Mina Gerais","MG",null);
		State rj = new State(null,"Rio de Janeiro","RJ",null);
		State pr = new State(null,"Paraná","PR",null);
		
		City saoPaulo = new City(null,"São Paulo",null,sp);
		City promissao = new City(null,"Promissao",null,sp);
		City barueri = new City(null,"Barueri",null,sp);
		City lins = new City(null,"Lins",null,sp);
		City beloHorizonte = new City(null,"Belo Horizonte",null,mg);
		City uberlandia = new City(null,"Uberlandia",null,mg);
		City rio = new City(null,"Rio de Janeiro",null,rj);
		City curitiba = new City(null,"Curitiba",null,pr);
		
		sp.getCityList().addAll(Arrays.asList(saoPaulo,promissao,barueri,lins));
		mg.getCityList().addAll(Arrays.asList(beloHorizonte,uberlandia));
		rj.getCityList().addAll(Arrays.asList(rio));
		pr.getCityList().addAll(Arrays.asList(curitiba));
		
		stateRepository.saveAll(Arrays.asList(sp,mg,rj,pr));
		cityRepository.saveAll(Arrays.asList(saoPaulo,promissao,barueri,lins,beloHorizonte,uberlandia,rio,curitiba));
		
		Customer joseph = new Customer(null,"Joseph Grey","joseh.grey@email.com",Tier.REGULAR);
		joseph.getPhones().addAll(Arrays.asList("11912340123","11912340124"));
		
		Address ad1 = new Address(null,"Home","Av Paulista","1234, apt123","Bela Vista","04500001",saoPaulo,joseph);
		Address ad2 = new Address(null,"Home","Av Pedro de Toledo","1234, apt1","Centro","16370000",promissao,joseph);
		joseph.getAdressList().addAll(Arrays.asList(ad1, ad2));
		
		customerRepository.saveAll(Arrays.asList(joseph));
		addressRepository.saveAll(Arrays.asList(ad1,ad2));
		
//		fragrance.getProductList().addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
//		color.getProductList().addAll(Arrays.asList(p8,p9));
//		skincare.getProductList().addAll(Arrays.asList(p10));
	
		
		
		
	}

}
