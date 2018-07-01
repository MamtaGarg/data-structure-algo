package com.myown.ds.algo.graph;

import java.util.Iterator;
import java.util.LinkedList;

public class BFSGraph {

	private int v;

	private LinkedList<Integer> adj[];

	BFSGraph(int v) {
		this.v = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList();
		}
	}

	private void addEdge(int v, int w) {
		adj[v].add(w);
	}

	private void BFS(int vertex) {
		boolean[] visited = new boolean[v];
		LinkedList<Integer> queue = new LinkedList<>();
		visited[vertex] = true;
		queue.add(vertex);

		while (queue.size() != 0) {
			vertex = queue.poll();
			System.out.println(vertex + " ");
			Iterator<Integer> i = adj[vertex].listIterator();
			while(i.hasNext()) {
				int e = i.next();
				if(!visited[e]) {
					visited[e] = true;
					queue.add(e);
				}
			}
		}
	}

	public static void main(String[] args) {
		BFSGraph g = new BFSGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " + "(starting from vertex 2)");

		g.BFS(0);
	}

}
