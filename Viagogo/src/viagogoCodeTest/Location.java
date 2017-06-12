package viagogoCodeTest;

import java.util.ArrayList;
public class Location {

	private ArrayList<Event> events = new ArrayList<Event>();
	public Location() {
		
	}
	
	public boolean hasEvent() {
		if (!events.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public void autofillEvent(int eventId) {
		events.add(new Event(eventId));
	}
	public void addEvent(Event newEvent) {
		events.add(newEvent);
	}

	public Event removeEvent(Event thisEvent) {
		
		return events.remove(events.indexOf(thisEvent));
	}
	
	public Event getEvent(int index) {
		return events.get(index);
	}
	
	public ArrayList<Event> getEvents() {
		return events;
	}
}