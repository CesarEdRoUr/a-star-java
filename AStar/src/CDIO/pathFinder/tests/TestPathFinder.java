package CDIO.pathFinder.tests;

import java.awt.Point;
import java.util.ArrayList;

import CDIO.pathFinder.AStar;
import CDIO.pathFinder.AreaMap;
import CDIO.pathFinder.PathFinder;
import CDIO.pathFinder.graphics.PrintMap;
import CDIO.pathFinder.heuristics.AStarHeuristic;
import CDIO.pathFinder.heuristics.DiagonalHeuristic;
import CDIO.pathFinder.utils.Logger;

/*
 * Hvorfor virker det ikke???
 */
public class TestPathFinder {
	private static int mapWith = 20;
	private static int mapHeight = 20;
	
	private static int[][] obstacleMap =   {{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0},
											{0,0,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,1,1,0},
											{0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,1,1,0,0},
											{0,0,0,0,1,1,0,0,1,0,0,0,0,0,0,1,1,0,0,0},
											{0,1,1,1,1,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0},
											{0,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,0,0,0},
											{1,1,1,1,1,1,1,1,0,0,0,0,1,1,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,1,1,0,0,0,0,1,1,0,0,0,0},
											{0,0,0,0,0,0,0,1,1,0,0,0,1,1,1,0,0,0,0,0},
											{0,0,0,0,0,0,1,1,0,0,0,0,1,0,0,0,0,0,0,0},
											{0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
											{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1}};
	
	private static int startX = 0;
	private static int startY = 1;
	private static int goalX = 16;
	private static int goalY = 18;
	
	
	public static void main(String[] args) {
		Logger log = new Logger();
		
		log.addToLog("Map initializing...");
		AreaMap map = new AreaMap(mapWith, mapHeight, obstacleMap);
		map.setStartLocation(startX, startY);
		map.setGoalLocation(goalX, goalY);
		
		PathFinder pathfinder = new PathFinder();
		ArrayList<Point> optimizedWaypoints = pathfinder.getWaypoints(map);
		
		log.addToLog("Printing map of optimized path...");
		new PrintMap(map, optimizedWaypoints);
	}
}
