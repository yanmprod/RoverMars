package Components;

import java.awt.Point;

public class Rover {
	private Point position;
	private String direction;
	
	public Rover() {
		position = new Point(); //(0,0) by default
		direction = "F"; // Forward init	
	}
	
	public void setPosition(int x, int y)	{ //bodek mashu
		position = new Point(x,y);
	}
	
	public Point getPosition() {
		return position;
	}
	
	public void moveNorth() {
		position.x--;
	}
	
	public void moveSouth() {
		position.x++;
	}
	
	public String getDirection() {
		return direction;
	}

	public void moveRight() {
		position.y++;
		
	}

	public void moveLeft() {
		position.y--;
		
	}


}
