package corso.spring.integration.stocks.model;

public class MarketItem {
	
	@Override
	public String toString() {
		return "MarketItem [description=" + description + ", openPrice="
				+ openPrice + ", price=" + price + ", symbol=" + symbol
				+ ", type=" + type + "]";
	}
	String type;
	String symbol;
	String description;
	double price;
	double openPrice;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getOpenPrice() {
		return openPrice;
	}
	public void setOpenPrice(double openPrice) {
		this.openPrice = openPrice;
	}
	
	


}
