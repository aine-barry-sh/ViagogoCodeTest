package viagogoCodeTest;

import java.util.ArrayList;

public class Grid {
	
	private Location[][] locations = new Location[Values.GRID_SIZE.value][Values.GRID_SIZE.value];
	
	public Grid() {
		autofillLocations();
	}
	
	private void autofillLocations() {
		
		int eventId = 1;
		
		//must initialize all of the locations (safety first) so loop through 2d array to do so and carry out any
		//additional functionality like planting seed information (randomly putting events into locations)
		//There are two loops so that both dimensions of the array will be explored.
		for (int i=0; i< locations.length; i++) {
			for (int j=0; j<locations.length; j++) {
				locations[i][j] = new Location();
				//for the purpose of the seed information, each location has a 1 in 10 chance of having an event
				if (MyTools.rollD10() == 5) {
					locations[i][j].autofillEvent(eventId); 
					eventId++;
				}
			}
		}
	}
	
	
	//takes in coordinates in a form as described in the requirements ([-4,2], [3,-8], [0,0])
	//and later transforms them into a format applicable to the 2D array
	//returns a string which lists the ids and lowest ticket price of the 5 nearest events. 
	//If there are a number of events that are the same distance from the given point, and the number of events 
	//gathered before this point is less than 5, all of these events will be included in the final string. 
	//A line of the string is in the format "Event x - $xx.xx, Distance x"
	public String getNearestEvents(int x_coor, int y_coor) {
		
		x_coor = transformCoordinate(x_coor);
		y_coor = transformCoordinate(y_coor);
		
		String returnString = "";
		int eventCount =0;
		for (int i=0; i< Values.GRID_SIZE.value && eventCount<=Values.NUMBER_OF_EVENTS.value; i++) {
			ArrayList<Event> events = exploreDistance(i, x_coor, y_coor);
			for (int j=0; j< events.size(); j++) {
				returnString+= events.get(j).toString() + ", Distance " + i + "\n";
				eventCount++;
			}
		}
		
		return returnString;
		
	}
	
	private ArrayList<Event> exploreDistance(int distance, int x_coor, int y_coor) {
		
		ArrayList<Event> events = new ArrayList<Event>();
		
		/**
		 * you get to a point that is x units away by either adding or taking away y or z from the coordinates 
		 * where x = y + z. So (0,0) is 3 units from (1,2) because (1,2) is ((0+1), (0+2))
		 * 
		 *  All of the points exactly the distance away basically form a ring around the given centre point 
		 *  To explore all of them, you have a loop that goes around equal to the distance. Within each loop, you apply the
		 *  transformation and arrange the numbers in the following format 
		 *  
		 *  [x,y]
		 *  [-x, -y]
		 *  [x, -y]
		 *  [y, -x]
		 *  
		 *  By doing this, you can examine every point that is an exact distance from the given point.
		 */
		int assc =0; int desc = distance;
		for (assc =0; assc<distance; assc++, desc--) {	
			for (int j =0; j<4; j++) {
				int newX = (x_coor+assc), newY=(y_coor+desc);
				if (j==0) {
					//do not transform further
				} else if (j==1) {
					newX = newX*-1;
					newY = newY*-1;
				} else if (j==2) {
					newY = newY*-1;
				} else {
					int temp = newX;
					newX = newY;
					newY = temp*-1;
				}
				
				if (newX >= 0 && newX < Values.GRID_SIZE.value && newY >= 0 && newY < Values.GRID_SIZE.value) {
					events.addAll(locations[newX][newY].getEvents());
				}
			}
		}
		return events;
	}
	
	
	//in the example given in the requirements, a grid reaching from -10 to 10. 
	//this is accounted for in a 2d array of 21*21 when a line for 0 is included. 
	//this method converts a coordinate from the "normal" form to the 2d array form
	private int transformCoordinate(int coordinate) {
		return coordinate + ((Values.GRID_SIZE.value)/2);
	}
}
