package CDIO.pathFinder;

import java.awt.Point;
import java.util.ArrayList;

import CDIO.pathFinder.bresenhamsLine.BresenhamsLine;
import CDIO.pathFinder.graphics.PrintMap;
import CDIO.pathFinder.heuristics.AStarHeuristic;
import CDIO.pathFinder.heuristics.DiagonalHeuristic;
import CDIO.pathFinder.utils.Logger;
import CDIO.pathFinder.utils.StopWatch;

public class PathFinder {

	AreaMap map;
	Logger log = new Logger();
	StopWatch s = new StopWatch();
	
	public ArrayList<Point> getWaypoints(AreaMap map) {
		this.map = map;
		
		log.addToLog("AStar Heuristic initializing...");
		AStarHeuristic heuristic = new DiagonalHeuristic();
		
		log.addToLog("AStar initializing...");
		AStar aStar = new AStar(map, heuristic);
		
		log.addToLog("Calculating shortest path with AStar...");
		Path shortestPath = aStar.calcShortestPath(map.getStartLocationX(), map.getStartLocationY(), map.getGoalLocationX(), map.getGoalLocationY());
		
		//log.addToLog("Printing map of shortest path...");
		//new PrintMap(map, shortestPath);
		
		log.addToLog("Calculating optimized waypoints...");
		s.start();
		ArrayList<Point> waypoints = calculateWayPoints(shortestPath);
		s.stop();
		log.addToLog("Time to calculate waypoints: " + s.getElapsedTime() + " ms");
		
		return waypoints;
	}
	
	private ArrayList<Point> calculateWayPoints(Path shortestPath) {
		ArrayList<Point> waypoints = new ArrayList<Point>();
		
		shortestPath.prependWayPoint(map.getStartNode());
		shortestPath.appendWayPoint(map.getGoalNode());
		
		Point p1 = shortestPath.getWayPoint(0);
		int p1Number = 0;
		waypoints.add(p1);
		
		Point p2 = shortestPath.getWayPoint(1);
		int p2Number = 1;
		
		while(!p2.equals(shortestPath.getWayPoint(shortestPath.getLength()-1))) {
			if(lineClear(p1, p2)) {
				//make p2 the next point in the path
				p2Number++;
				p2 = shortestPath.getWayPoint(p2Number);
			} else {
				p1Number = p2Number-1;
				p1 = shortestPath.getWayPoint(p1Number);
				waypoints.add(p1);
				log.addToLog("Got waypoint: " + p1.toString());
				p2Number++;
				p2 = shortestPath.getWayPoint(p2Number);
			}
		}
		waypoints.add(p2);
		
		return waypoints;
	}
	
	private boolean lineClear(Point a, Point b) {
		ArrayList<Point> pointsOnLine = BresenhamsLine.getPointsOnLine(a, b);
		for(Point p : pointsOnLine) {
			if(map.getNode(p.x, p.y).isObstacle) {
				return false;
			}
		}
		return true;
	}
}
