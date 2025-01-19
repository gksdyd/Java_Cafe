package cafe_project.app;

public class Product {

	int price;
	String name;
	String type;
	
	public Product() {}
	
	public Product(String type) {
		this.type = type;
	}
	
	public Product(int price, String name) {
		this.price = price;
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
}
