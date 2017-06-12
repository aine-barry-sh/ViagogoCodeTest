package viagogoCodeTest;

public enum Values {

	TICKET_CAPACITY(20),
	MAX_TICKET_PRICE(100),
	GRID_SIZE(21),
	MIN_TICKET_PRICE(1),
	NUMBER_OF_EVENTS(5);
	
	
	
	 
	protected int value;
	
	private Values(int value) {
		this.value = value;
	}

	
}
