package com.hino.loyalty.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hino.loyalty.domain.Product;
import com.hino.loyalty.dto.CategoryDTO;
import com.hino.loyalty.dto.ProductDTO;
import com.hino.loyalty.resource.utils.URL;
import com.hino.loyalty.service.ProductService;

@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Product> find(@PathVariable Integer id) {
		Product product = productService.find(id);
		
		return ResponseEntity.ok().body(product);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<ProductDTO>> findPage(
			@RequestParam(value="skuName", defaultValue ="") String skuName,
			@RequestParam(value="categories", defaultValue ="") String categories,
			@RequestParam(value="page", defaultValue ="0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "skuName") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		
		List<Integer> categoryIdList = URL.decodeIntList(categories);
		
		Page<Product> productList = productService.search(URL.decodeParam(skuName), categoryIdList, page, linesPerPage, orderBy, direction);
		Page<ProductDTO> dtoList = productList.map(obj -> new ProductDTO(obj));
		
		return ResponseEntity.ok().body(dtoList);
	}
}
