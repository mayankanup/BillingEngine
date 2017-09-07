package mayank.anup.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
	
	private List<LineItem> lineItems = new ArrayList<LineItem>();
	Double orderTotal = 0.0;
	Double lineTotal = 0.0;
	Double salesTaxTotal = 0.0;
	public List<LineItem> getLineItems() {
		return lineItems;
	}
	public void setLineItems(List<LineItem> lineItems) {
		this.lineItems = lineItems;
	}
	public Double getOrderTotal() {
		return orderTotal;
	}
	public void setOrderTotal(Double orderTotal) {
		this.orderTotal = orderTotal;
	}
	public Double getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}
	public Double getSalesTaxTotal() {
		return salesTaxTotal;
	}
	public void setSalesTaxTotal(Double salesTaxTotal) {
		this.salesTaxTotal = salesTaxTotal;
	}
	public void addLineItem(LineItem line) {
		this.lineItems.add(line);
	}

}
