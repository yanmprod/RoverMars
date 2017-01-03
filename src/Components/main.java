package Components;

import java.awt.Point;
import java.util.Scanner;

import Components.Rover;

// A main function to create the world of the map, roven, controller
// Code written by Yaniv Mor
// Any questions can be sent to my mail yanmprod@gmail.com
public class main {

	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Rover rover = new Rover();
		boolean run = true;
		
		
		System.out.println("Please insert rows:");
		String rows = reader.next();
		
		System.out.println("Please insert columns:");
		String columns = reader.next();
		Map map = new Map(Integer.parseInt(rows), Integer.parseInt(columns)); 
		do {
			System.out.println("1. Insert obstacle");
			System.out.println("2. Start moving");
			System.out.println("q. Quit");
			
			
			String input = reader.next();
			switch(input.toString())
			{
				case "1":
					System.out.println("Insert like 2 1");
					int obstaclex = reader.nextInt();
					int obstacley = reader.nextInt();
					map.obstacles.add(new Point(obstaclex, obstacley));
					break;
				case "2":
					Controller _control = new Controller(map, rover);
					_control.executeCommander();
					break;
				case "q":
					run = false;
				default:
					System.out.println("Unknown command" + input.toString());
			}
			
		} while (run);
		
		reader.close();
	}
	
}
