package mayank.anup.model;

public class LineItem {
	
	String productId;
	long quantity;
	Double lineTotal;
	Double salesTax;
	Product product;
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public Double getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(Double lineTotal) {
		this.lineTotal = lineTotal;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product p) {
		this.product = p;
	}
	public Double getSalesTax() {
		return salesTax;
	}
	public void setSalesTax(Double salesTax) {
		this.salesTax = salesTax;
	}
}
