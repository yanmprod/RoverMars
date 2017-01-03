package Components;

import java.awt.Point;
import java.util.Scanner;

public class Controller {

	public Map map;
	public Rover rover;
	
	public Controller(Map _map, Rover _rover)	{
		map = _map;
		rover = _rover;
	}
	
	public void executeCommander()	{
		Point _desiredPoint;
		Scanner reader = new Scanner(System.in);
		Boolean isObstacle = false;
		printView();
		boolean run = true;

		
		//main flow of the rover on the area
		do
		{
			print("Enter next command: (north east south west | Q)");
			String input = reader.next();
			
			switch (input.toString()) {
				case "north":
					if(rover.getPosition().x - 1 < 0) //bounds check
					{
						Point newPoint = new Point(map.getRows() - 1, rover.getPosition().y);
						isObstacle = map.checkObstacle(newPoint);
						if(!isObstacle)
							rover.setPosition(map.getRows() - 1, rover.getPosition().y);
						else 
							System.out.println("Obstacle. Cannot move to this position");	
					}
					else {
						_desiredPoint = new Point((rover.getPosition().x - 1), rover.getPosition().y);
						if(map.checkObstacle(_desiredPoint))
							System.out.println("Obstacle. Cannot move to this position");	
						else
							rover.moveNorth();
					}
					break;
						

				case "south":	
					if(rover.getPosition().x + 1 == map.getRows()) 
					{
						Point newPoint = new Point(0, rover.getPosition().y);
						isObstacle = map.checkObstacle(newPoint);
						if(!isObstacle)
							rover.setPosition(0, rover.getPosition().y);
						else
							System.out.println("Obstacle. Cannot move to this position");
					}
					else {
						_desiredPoint = new Point((rover.getPosition().x + 1), rover.getPosition().y);
						if(map.checkObstacle(_desiredPoint))
							System.out.println("Obstacle. Cannot move to this position");	
						else
							rover.moveSouth();
					}
					break;
	
					
				case "east":
					if(rover.getPosition().y + 1 == map.getColumns())
					{
						Point newPoint = new Point(rover.getPosition().x, 0);
						isObstacle = map.checkObstacle(newPoint);
						if(!isObstacle)
							rover.setPosition(rover.getPosition().x, 0);
						else
							System.out.println("Obstacle. Cannot move to this position");
					}
					else {
					_desiredPoint = new Point((rover.getPosition().x), rover.getPosition().y + 1);
					if(map.checkObstacle(_desiredPoint))
						System.out.println("Obstacle. Cannot move to this position");		
					else
						rover.moveRight();
					}
					break;
						
				case "west":
					if((rover.getPosition().y - 1) < 0)
					{
						Point newPoint = new Point(rover.getPosition().x, map.getColumns() - 1);
						isObstacle = map.checkObstacle(newPoint);
						if(!isObstacle)
							rover.setPosition(rover.getPosition().x, map.getColumns() - 1);
						else
							System.out.println("Obstacle. Cannot move to this position");	
					}
					else {
					_desiredPoint = new Point((rover.getPosition().x), rover.getPosition().y - 1);
					if(map.checkObstacle(_desiredPoint)) 
						System.out.println("Obstacle. Cannot move to this position");	
					else
						rover.moveLeft();
					}
					break;
					
				case "Q":
					run = false;
					
				default:
					print("Command unknown: " + input.toString());
					break;
			} 
			System.out.println("-----------------");
			printView();
			
		} while(run);
		

			
	}
	
	private void printView() {
		int rows = map.getRows(); //5
		int columns = map.getColumns(); // 10
		
		for(int i=0; i<rows; i++)
			for(int j=0; j<columns; j++)
			{
				Point current = new Point(i,j);
				if(map.checkObstacle(current))
					System.out.print("x");
				else if(rover.getPosition().equals(current))
					System.out.print("u");
				else
					System.out.print(".");
				if(j + 1 == columns)
					System.out.print("\n");
				
			}
		
	}

	public Map getMap() {
		return this.map;
	}
	
	public Rover getRover() {
		return this.rover;
	}
	
	

	
	private void print(String line) { //stam
	    System.out.println(line);
	}
}
