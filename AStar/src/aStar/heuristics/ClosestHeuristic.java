package aStar.heuristics;

import aStar.AStarHeuristic;

/**
 * A heuristic that uses the tile that is closest to the target
 * as the next best tile.
 */
public class ClosestHeuristic implements AStarHeuristic {

	public float getEstimatedDistanceToGoal(int startX, int startY, int goalX, int goalY) {		
		float dx = goalX - startX;
		float dy = goalY - startY;
		
		//float result = (float) (Math.sqrt((dx*dx)+(dy*dy)));
		//Optimization! Changed to Manhattan distance:
		
		float result = (float) (dx*dx)+(dy*dy);
		
		
		return result;
	}

}
