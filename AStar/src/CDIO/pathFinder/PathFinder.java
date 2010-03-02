package CDIO.pathFinder;

import java.awt.Point;
import java.util.ArrayList;
import CDIO.pathFinder.heuristics.AStarHeuristic;
import CDIO.pathFinder.heuristics.DiagonalHeuristic;
import CDIO.pathFinder.utils.Logger;
import CDIO.pathFinder.utils.StopWatch;

public class PathFinder {
	public ArrayList<Point> getWaypoints(AreaMap map) {
		Logger log = new Logger();
		StopWatch s = new StopWatch();
		
		log.addToLog("AStar Heuristic initializing...");
		AStarHeuristic heuristic = new DiagonalHeuristic();
		
		log.addToLog("AStar initializing...");
		AStar aStar = new AStar(map, heuristic);
		
		log.addToLog("Calculating shortest path with AStar...");
		s.start();
		Path shortestPath = aStar.calcShortestPath(map.getStartLocationX(), map.getStartLocationY(), map.getGoalLocationX(), map.getGoalLocationY());
		
		s.stop();
		
		log.addToLog("Time to calculate waypoints: " + s.getElapsedTime() + " ms");
		
		return null;
	}
	
	private ArrayList<Point> calculateWayPoints(Path shortestPath) {
		
		return null;
	}
	
	private boolean lineClear(Point a, Point b) {
		
		return false;
	}
}
