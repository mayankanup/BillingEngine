package mayank.anup.model;

public class Product {

	private String id;
	private Double listPrice;
	private ProductSalesTaxType salesTaxType;
	private String displayName;
	private String currency = "INR";
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Double getListPrice() {
		return listPrice;
	}
	public void setListPrice(Double listPrice) {
		this.listPrice = listPrice;
	}
	public ProductSalesTaxType getSalesTaxType() {
		return salesTaxType;
	}
	public void setSalesTaxType(ProductSalesTaxType salesTaxType) {
		this.salesTaxType = salesTaxType;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;		
	}
	public String getDisplayName() {
		return displayName;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
}
