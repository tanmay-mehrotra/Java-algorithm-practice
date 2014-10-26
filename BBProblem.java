package Random;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

class GraphNode{
	int data;
	public GraphNode(int data){
		this.data = data;
	}
}

public class BBProblem {
    static Map<GraphNode,LinkedList<GraphNode>> dag = new HashMap<>();
    
    public static void main(String args[]){
    	//setup DAG as per the problem
    	GraphNode a = new GraphNode(2);
    	GraphNode b = new GraphNode(0);
    	GraphNode c = new GraphNode(5);
    	GraphNode d = new GraphNode(0);
    	GraphNode e = new GraphNode(0);
    	GraphNode f = new GraphNode(10);
    	GraphNode g = new GraphNode(0);
    	GraphNode h = new GraphNode(0);
    	GraphNode i = new GraphNode(0);
    	
    	LinkedList<GraphNode> alist = new LinkedList<>();
    	alist.add(b);alist.add(g);
    	dag.put(a, alist);
    	
    	LinkedList<GraphNode> clist = new LinkedList<>();
    	clist.add(i);clist.add(d);
    	dag.put(c, clist);
    	
    	LinkedList<GraphNode> ilist = new LinkedList<>();
    	alist.add(e);
    	dag.put(i, ilist);
    	
    	LinkedList<GraphNode> elist = new LinkedList<>();
    	elist.add(g);
    	dag.put(e, elist);
    	
    	LinkedList<GraphNode> flist = new LinkedList<>();
    	flist.add(d);
    	dag.put(f, flist);
    	
    	LinkedList<GraphNode> dlist = new LinkedList<>();
    	alist.add(h);
    	dag.put(d, dlist);
    	
    	
    	
    }
}
