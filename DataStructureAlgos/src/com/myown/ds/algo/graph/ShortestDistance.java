package com.myown.ds.algo.graph;

/**
 * The Class ShortestDistance.
 */
public class ShortestDistance {

	/** The Constant v. */
	private static final int v = 9;

	/**
	 * Min distance.
	 *
	 * @param dist the dist
	 * @param sptSet the spt set
	 * @return the int
	 */
	private int minDistance(int[] dist, boolean[] sptSet) {
		int minValue = Integer.MAX_VALUE, minIndex = -1;
		for (int index = 0; index < v; index++) {
			if (sptSet[index] == false && dist[index] <= minValue) {
				minValue = dist[index];
				minIndex = index;
			}
		}
		return minIndex;
	}

	/**
	 * Find shortest path.
	 *
	 * @param graph the graph
	 * @param src the src
	 */
	private void findShortestPath(int[][] graph, int src) {
		boolean[] sptSet = new boolean[v];
		int[] dist = new int[v];

		for (int index = 0; index < v; index++) {
			sptSet[index] = false;
			dist[index] = Integer.MAX_VALUE;
		}

		dist[src] = 0;
		for (int count = 0; count < v - 1; count++) {
			int u = minDistance(dist, sptSet);
			sptSet[u] = true;
			for (int V = 0; V < v; V++) {
				if (!sptSet[V] && graph[u][V] != 0 && dist[u] + graph[u][V] < dist[V]
						&& dist[u] != Integer.MAX_VALUE) {
					dist[V] = dist[u] + graph[u][V];
				}
			}
		}
		printDistance(dist);
	}

	/**
	 * Prints the distance.
	 *
	 * @param dist the dist
	 */
	private void printDistance(int[] dist) {
		for (int index = 0; index < v; index++) {
			System.out.println(index + "\t\t" + dist[index]);
		}
	}

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		ShortestDistance distance = new ShortestDistance();
		int[][] graph = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		distance.findShortestPath(graph, 0);
	}

}
