package aStar;

import aStar.heuristics.AStarHeuristic;
import aStar.heuristics.ClosestHeuristic;
import aStar.utils.Logger;
import aStar.utils.StopWatch;

public class TestAStar {
	
	private static int mapWith = 100;
	private static int mapHeight = 100;
	
	private static int startX = 91;
	private static int startY = 97;
	private static int goalX = 14;
	private static int goalY = 7;
	
	
	public static void main(String[] args) {
		Logger log = new Logger();
		StopWatch s = new StopWatch();
		s.start();
		
		log.addToLog("Map initializing...");
		AreaMap map = new AreaMap(mapWith, mapHeight);
		
		log.addToLog("Heuristic initializing...");
		AStarHeuristic heuristic = new ClosestHeuristic();
		
		log.addToLog("Pathfinder initializing...");
		AStar pathFinder = new AStar(map, heuristic);
		
		log.addToLog("Calculating shortest path...");
		pathFinder.calcShortestPath(startX, startY, goalX, goalY);
		
		s.stop();
		log.addToLog("Time to calculate path in milliseconds: " + s.getElapsedTime());
		
		log.addToLog("Printing map of shortest path...");
		pathFinder.printPath();
	}

}
