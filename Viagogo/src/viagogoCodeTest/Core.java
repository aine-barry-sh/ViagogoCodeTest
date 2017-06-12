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
		

		
		String [] string_coordinates = input.split(",");
		try {
			int x_coor = Integer.parseInt(string_coordinates[0]);
			int y_coor = Integer.parseInt(string_coordinates[1]);
			System.out.println(myMap.getNearestEvents(x_coor, y_coor));
			in.close();
			
		} catch (Exception e) {
			System.out.println("Error: invalid input");
			in.close();
		}
		
		
	}
	
}
