package viagogoCodeTest;

import java.text.DecimalFormat;
import java.util.Random;

public abstract class MyTools {
	
	

	public static int getRandomInt() {
		
		return 1;
	}
	
	
	public static int rollD10() {
		
		Random r = new Random();
		return r.nextInt(9) +1;
	}
	
	public static double getRandomTicketPrice() {
		
		Random r = new Random();
		Double randomDouble = Values.MIN_TICKET_PRICE.value + (Values.MAX_TICKET_PRICE.value - Values.MIN_TICKET_PRICE.value) * r.nextDouble();
		
		//then need to make sure it only has two decimal places
		DecimalFormat df = new DecimalFormat("#.##"); 
		return Double.valueOf(df.format(randomDouble));
	}
}
