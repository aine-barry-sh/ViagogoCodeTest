package viagogoCodeTest;

import java.util.ArrayList;
public class Event {
	
	private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
	private int id;
	
	public Event(int eventId) {
		this.id = eventId;
		seedTickets();
	}
	
	public void seedTickets() {
		for (int i =0; i< Values.TICKET_CAPACITY.value; i++) {
			tickets.add(new Ticket(MyTools.getRandomTicketPrice()));
		}
	}
	
	public void addTicket(Ticket newTicket) {
		tickets.add(newTicket);
	}
	
	public Ticket getCheapestTicket() {
		return tickets.get(getIndexOfCheapestTicket());
	}
	
	
	
	private int getIndexOfCheapestTicket() {
		double cheapestTicketAmount = 500000;
		int cheapestIndex=0;
		for (int i =0; i<tickets.size(); i++) {
			if (tickets.get(i).getPrice() < cheapestTicketAmount) {
				cheapestIndex = i;
				cheapestTicketAmount = tickets.get(i).getPrice();
			}
		}
		return cheapestIndex;
	}
	
	public String toString() {
		return "Event " + id + " - $" + getCheapestTicket().getPrice();
	}
	
	
	
}