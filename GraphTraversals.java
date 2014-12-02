package Random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

class Vertex{
	int value;
	boolean isVisited;

	public Vertex(int value, boolean isVisited){
		this.value = value;
		this.isVisited = isVisited;
	}
}


public class GraphTraversals {
	static Vertex v1 = new Vertex(1, false);
	static Vertex v2 = new Vertex(2, false);
	static Vertex v3 = new Vertex(5, false);
	static Vertex v4 = new Vertex(7, false);
	static Vertex v5 = new Vertex(6, false);
	static Vertex v6 = new Vertex(-5, false);

	public static void main(String args[]){
		//GraphTraversals.BFS(GraphTraversals.init(), v1);
		System.out.println("inside DFS");
		GraphTraversals.DFS(GraphTraversals.init(), v1);
	}

	public static Map<Vertex, LinkedList<Vertex>> init(){
		Map<Vertex, LinkedList<Vertex>> g = new HashMap<>();
		
		 LinkedList<Vertex> l1 = new LinkedList<Vertex>();
		l1.add(v2);l1.add(v3);
		g.put(v1, l1);

		LinkedList<Vertex> l2 = new LinkedList<Vertex>();
		l2.add(v3);l2.add(v5);
		g.put(v2, l2);

		LinkedList<Vertex> l3 = new LinkedList<Vertex>();
		l3.add(v5);
		g.put(v3, l3);

		LinkedList<Vertex> l4 = new LinkedList<Vertex>();
		l4.add(v3);
		g.put(v4, l4);

		LinkedList<Vertex> l5= new LinkedList<Vertex>();
		l5.add(v4);l5.add(v6);
		g.put(v5, l5);

		LinkedList<Vertex> l6= new LinkedList<Vertex>();
		l6.add(v4);
		g.put(v6, l6);

		return g;
	}

	public static void BFS(Map<Vertex, LinkedList<Vertex>> graph, Vertex start){
		System.out.println("inside BFS");
		Queue<Vertex> q = new LinkedList<>();
		q.add(start);
		while(!q.isEmpty()){
			Vertex curr_vertex = q.poll();
			if(!curr_vertex.isVisited){
				curr_vertex.isVisited = true;
				System.out.println(curr_vertex.value);
				if(graph.containsKey(curr_vertex)){
					for(Vertex neighbour : graph.get(curr_vertex)){
						q.add(neighbour);
					}
				}
			}
		}
	}

	public static void DFS(Map<Vertex, LinkedList<Vertex>> graph, Vertex start){
		System.out.println(start.value);
		start.isVisited = true;
		if(graph.containsKey(start)){
			for(Vertex neighbour : graph.get(start)){
				if(!neighbour.isVisited){
					DFS(graph,neighbour);
				}
			}
		}
	}
	
}
