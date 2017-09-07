package mayank.anup.controller;

import java.util.List;

import mayank.anup.model.LineItem;
import mayank.anup.model.Order;
import mayank.anup.model.Product;

public class BillingEngine {

	
	public static Order getOrderPrice(List<LineItem> lineItems) throws Exception{
		Order o = new Order();
		for(LineItem line: lineItems){
			Product p = ProductDAO.getInstance().getProduct(line.getProductId());
			if(p==null){
				throw new Exception("Found invalid product id : "+line.getProductId());
			}
			LineItem calculatedLine = new LineItem();
			calculatedLine.setProduct(p);
			calculatedLine.setProductId(line.getProductId());
			calculatedLine.setQuantity(line.getQuantity());
			calculatedLine.setLineTotal(p.getListPrice()*line.getQuantity());
			Double salesTax = getSalesTax(p, line.getQuantity());
			calculatedLine.setSalesTax(salesTax);
			o.addLineItem(calculatedLine);
			
		}
		processOrderTotals(o);
		return o;
	}

	private static void processOrderTotals(Order o) {
		for(LineItem line: o.getLineItems()){
			o.setSalesTaxTotal(o.getSalesTaxTotal()+line.getSalesTax());
			o.setLineTotal(o.getLineTotal()+line.getLineTotal());
		}
		o.setOrderTotal(o.getLineTotal()+o.getSalesTaxTotal());
	}

	private static Double getSalesTax(Product p, long quantity) {
		Double taxRate = 0.0;
		switch(p.getSalesTaxType()){
		case A:
			taxRate = 0.1;
			break;
		case B:
			taxRate = 0.2;
			break;
		case C:
			taxRate = 0.0;
			break;
		}
		return p.getListPrice()*quantity*taxRate;
	}
}
