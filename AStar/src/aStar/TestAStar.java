package aStar;

import aStar.heuristics.AStarHeuristic;
import aStar.heuristics.ClosestHeuristic;
import aStar.heuristics.DiagonalHeuristic;
import aStar.utils.Logger;
import aStar.utils.StopWatch;

public class TestAStar {
	
	private static int mapWith = 320;
	private static int mapHeight = 240;
	
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
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
											{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1},
											{0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1}};
	
	private static int startX = 0;
	private static int startY = 1;
	private static int goalX = 319;
	private static int goalY = 239;
	
	
	public static void main(String[] args) {
		Logger log = new Logger();
		StopWatch s = new StopWatch();
		
		log.addToLog("Map initializing...");
		AreaMap map = new AreaMap(mapWith, mapHeight, obstacleMap);
		
		log.addToLog("Heuristic initializing...");
		AStarHeuristic heuristic = new DiagonalHeuristic();
		
		log.addToLog("Pathfinder initializing...");
		AStar pathFinder = new AStar(map, heuristic);
		
		log.addToLog("Calculating shortest path...");
		s.start();
		pathFinder.calcShortestPath(startX, startY, goalX, goalY);
		s.stop();
		
		log.addToLog("Time to calculate path in milliseconds: " + s.getElapsedTime());
		
		log.addToLog("Printing map of shortest path...");
		pathFinder.printPath();
	}

}
