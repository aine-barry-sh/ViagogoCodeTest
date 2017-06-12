package viagogoCodeTest;

import java.util.Scanner;

//this will be the center point of this project 
//the chain of creating and managing objects will begin here
public class Core {

	
	public static void main(String [] args) {
		
		Grid myMap = new Grid();
		
		Scanner in = new Scanner(System.in);
		System.out.println("Please input coordinates in the format x,y: ");
		
		String input = in.nextLine();
		String pattern = "[0-9]{1,3},[0-9]{1,3}";
		

		
		String [] string_coordinates = input.split(",");
		int x_coor = Integer.parseInt(string_coordinates[0]);
		int y_coor = Integer.parseInt(string_coordinates[1]);
		System.out.println("Closest events to (" + x_coor + "," + y_coor + "):");
		System.out.println(myMap.getNearestEvents(x_coor, y_coor));
//		
//		if (!pattern.equals(input)) {
//			System.out.println("Error: invalid input.");
//			
//		} else {
//			String [] string_coordinates = input.split(",");
//			int x_coor = Integer.getInteger(string_coordinates[0]);
//			int y_coor = Integer.getInteger(string_coordinates[1]);
//			
//			if (validateCoordinates(x_coor, y_coor)) {
//				System.out.println("Closest events to (" + x_coor + "," + y_coor + "):");
//				System.out.println(myMap.getNearestEvents(x_coor, y_coor));
//			} else {
//				System.out.println("Error: input out of bounds");
//			}
//		} 
		
		
		
	}
	
	
	
	private static boolean validateCoordinates(int x, int y) {
		
		
		return true;
	}
}
