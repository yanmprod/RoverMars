package Components;

import java.awt.Point;
import java.util.ArrayList;

public class Map {
	
	public ArrayList<Point> obstacles;
	private Point _map[][];
	private int rows;
	private int columns;
	
	public Map(int _rows, int _columns) {
		obstacles = new ArrayList<Point>();
		rows = _rows;
		columns = _columns;
		_map = new Point[rows][columns];
		for(int i=0; i<rows; i++)
			for(int j=0; j<columns; j++)
			{
				_map[i][j] = new Point(i,j);
			}
	}
	
	public boolean checkObstacle(Point _desiredPoint) {
		if(obstacles.contains(_desiredPoint))
			return true;
		else return false;
		
	}
	public int getRows() {
		return rows;
	}
	
	public int getColumns() {
		return columns;
	}
	
}
