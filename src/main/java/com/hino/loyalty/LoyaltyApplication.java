package com.hino.loyalty;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.hino.loyalty.domain.Address;
import com.hino.loyalty.domain.BoletoPayment;
import com.hino.loyalty.domain.Category;
import com.hino.loyalty.domain.City;
import com.hino.loyalty.domain.CreditCardPayment;
import com.hino.loyalty.domain.Customer;
import com.hino.loyalty.domain.Payment;
import com.hino.loyalty.domain.Product;
import com.hino.loyalty.domain.PurchaseItem;
import com.hino.loyalty.domain.PurchaseOrder;
import com.hino.loyalty.domain.State;
import com.hino.loyalty.domain.enums.PaymentStatus;
import com.hino.loyalty.domain.enums.Tier;
import com.hino.loyalty.repository.AddressRepository;
import com.hino.loyalty.repository.CategoryRepository;
import com.hino.loyalty.repository.CityRepository;
import com.hino.loyalty.repository.CustomerRepository;
import com.hino.loyalty.repository.PaymentRepository;
import com.hino.loyalty.repository.ProductRepository;
import com.hino.loyalty.repository.PurchaseItemRepository;
import com.hino.loyalty.repository.PurchaseOrderRepository;
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
	@Autowired
	private PurchaseOrderRepository purchaseOrderRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	@Autowired
	private PurchaseItemRepository purchaseItemRepository;
	
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
		
		Category service = new Category(null,"Service","Category related to any service.");
		Category accessory = new Category(null,"Accessory","Category related to any accessory.");
		Category gift = new Category(null,"Gift","Category related to any regular gift.");
		Category loyaltyGift = new Category(null,"Loyalty Gift","Category related to any loyalty gift.");
		Category sample = new Category(null,"Sample","Category related to any sample.");
		
		Product p1 = new Product(null, "0123", "CKOne","Calvin Kein", BigDecimal.valueOf(100.00));
		Product p2 = new Product(null, "0124", "Eternity","Calvin Kein", BigDecimal.valueOf(150.00));
		Product p3 = new Product(null, "0125", "212","Carolina Herrera", BigDecimal.valueOf(120.00));
		Product p4 = new Product(null, "0126", "Polo Red","Polo Ralph Lauren", BigDecimal.valueOf(130.00));
		Product p5 = new Product(null, "0127", "Polo Blue","Polo Ralph Lauren", BigDecimal.valueOf(125.00));
		Product p6 = new Product(null, "0128", "Polo Green","Polo Ralph Lauren", BigDecimal.valueOf(125.00));
		Product p7 = new Product(null, "0129", "Polo Black","Polo Ralph Lauren", BigDecimal.valueOf(139.99));
		Product p8 = new Product(null, "0130", "Rouge lip stick","M.A.C.", BigDecimal.valueOf(69.90));
		Product p9 = new Product(null, "0131", "Dark lips","M.A.C.", BigDecimal.valueOf(89.90));
		Product p10 = new Product(null, "0132", "Serum eye lift","Dermage", BigDecimal.valueOf(1199.99));
		
		fragrance.getProductList().addAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7));
		color.getProductList().addAll(Arrays.asList(p8,p9));
		skincare.getProductList().addAll(Arrays.asList(p10));

		p1.getCategoryList().addAll(Arrays.asList(fragrance));
		p2.getCategoryList().addAll(Arrays.asList(fragrance));
		p3.getCategoryList().addAll(Arrays.asList(fragrance));
		p4.getCategoryList().addAll(Arrays.asList(fragrance));
		p5.getCategoryList().addAll(Arrays.asList(fragrance));
		p6.getCategoryList().addAll(Arrays.asList(fragrance));
		p7.getCategoryList().addAll(Arrays.asList(fragrance));
		p8.getCategoryList().addAll(Arrays.asList(color));
		p9.getCategoryList().addAll(Arrays.asList(color));
		p10.getCategoryList().addAll(Arrays.asList(skincare));
		
		categoryRepository.saveAll(Arrays.asList(fragrance, color, skincare, hair, service, accessory, gift, loyaltyGift, sample));
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
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		PurchaseOrder order1 = new PurchaseOrder(null, 1, 32001, sdf.parse("05/11/1980 05:00"), joseph, ad2);  
		PurchaseOrder order2 = new PurchaseOrder(null, 1, 32002, sdf.parse("06/11/1980 05:00"), joseph, ad1);
		
		Payment payment1 = new BoletoPayment(null, PaymentStatus.PENDING, order1, sdf.parse("10/10/1990 00:00"), null);
		order1.setPayment(payment1);
		
		Payment payment2 = new CreditCardPayment(null, PaymentStatus.PENDING, order2, 3);
		order2.setPayment(payment2);
		
		joseph.getOrderList().addAll(Arrays.asList(order1, order2));
		
		purchaseOrderRepository.saveAll(Arrays.asList(order1, order2));
		
		paymentRepository.saveAll(Arrays.asList(payment1, payment2));
		
		PurchaseItem pi1 = new PurchaseItem(order1, p1, 0.00, 2, 500.00);
		PurchaseItem pi2 = new PurchaseItem(order1, p3, 0.00, 1, 399.99);
		PurchaseItem pi3 = new PurchaseItem(order2, p2, 100.00, 1, 199.99);
		
		order1.getPurchaseItems().addAll(Arrays.asList(pi1,pi2));
		order2.getPurchaseItems().addAll(Arrays.asList(pi3));
		
		p1.getPurchaseItems().addAll(Arrays.asList(pi1));
		p2.getPurchaseItems().addAll(Arrays.asList(pi3));
		p3.getPurchaseItems().addAll(Arrays.asList(pi2));
		
		purchaseItemRepository.saveAll(Arrays.asList(pi1,pi2,pi3));
		
	}

}
