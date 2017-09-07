package mayank.anup.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import mayank.anup.model.LineItem;
import mayank.anup.model.Order;

@RestController
@RequestMapping("/billing")
public class BillingController {

	@RequestMapping(method=RequestMethod.POST, path="/checkprice", produces="application/json")
	public ResponseEntity<Order> checkPrice(@RequestBody List<LineItem> lineItems) throws Exception {
		Order order = BillingEngine.getOrderPrice(lineItems);
		return new ResponseEntity<Order>(order, HttpStatus.OK);
	}
}
