package mayank.anup.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mayank.anup.model.Product;

@RestController
@RequestMapping("/products")
public class ProductController {
	
	public static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<List<Product>> listAllProducts() {
        List<Product> products = ProductDAO.getInstance().getAllProducts();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }
}
