package mayank.anup.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mayank.anup.model.Product;
import mayank.anup.model.ProductSalesTaxType;

public class ProductDAO {
	private List<Product> catalog = new ArrayList<Product>();
	private Map<String, Product> id_product_map = new HashMap<String, Product>();
	private static ProductDAO instance = new ProductDAO();
	
	public static ProductDAO getInstance(){
		return instance;
	}
	private ProductDAO(){
		init();
	}

	/*
	 * Initialize an in-memory catalog of 5 products with different prices and salestaxtype
	 */
	private void init() {
		System.out.println("Intializing in memory product catalog");
		Product p = new Product();
		p.setId("101");
		p.setListPrice(400.00);
		p.setDisplayName("Oxford Advance Learners Dictionary with DVD - ROM");
		p.setSalesTaxType(ProductSalesTaxType.C);
		catalog.add(p);
		
		p = new Product();
		p.setId("102");
		p.setListPrice(150.00);
		p.setDisplayName("Philips SHE1350 In-Ear Headphones (Black)");
		p.setSalesTaxType(ProductSalesTaxType.A);
		catalog.add(p);
		
		p = new Product();
		p.setId("103");
		p.setListPrice(1400.00);
		p.setDisplayName("Portronics Muffs XT Wireless Bluetooth Headphone ( Black)");
		p.setSalesTaxType(ProductSalesTaxType.A);
		catalog.add(p);
		
		p = new Product();
		p.setId("104");
		p.setListPrice(250.00);
		p.setDisplayName("Pillsbury Milk Choco Spread, 350g");
		p.setSalesTaxType(ProductSalesTaxType.B);
		catalog.add(p);
		
		p = new Product();
		p.setId("105");
		p.setListPrice(100.00);
		p.setDisplayName("Tetley Green Tea, Lemon & Honey, 30 Tea Bags");
		p.setSalesTaxType(ProductSalesTaxType.B);
		catalog.add(p);
		
		for(Product p1: catalog){
			id_product_map.put(p1.getId(), p1);
		}
	}
	
	public List<Product> getAllProducts(){
		return catalog;
	}
	
	public Product getProduct(String productId){
		return id_product_map.get(productId);
	}
}
