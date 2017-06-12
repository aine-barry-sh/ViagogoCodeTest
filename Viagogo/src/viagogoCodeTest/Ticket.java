package viagogoCodeTest;

public class Ticket {

	private double price; 
	
	
	public Ticket(double price) {
		this.price = price;
	}
	
	public Ticket() {
		//sets price to an invalid amount for the purpose of tests
		this.price = -1;
	}
	
	public String toString() {
		
		return "Price: $" + this.price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	public double getPrice() {
		return price;
	}
}
