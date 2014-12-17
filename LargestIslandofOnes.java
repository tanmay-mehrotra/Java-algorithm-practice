package Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Coordinates{
	int x, y;
	
	public Coordinates(int x, int y){
		this.x = x;
		this.y = y;
	}
}

public class LargestIslandofOnes {
	int islands[][] = {
			           {0,0,0,0,0,0},
			           {0,0,0,1,1,0},
			           {0,0,0,1,1,0},
			           {1,0,0,1,0,0}
			          };
	
	public static void main(String args[]){
		LargestIslandofOnes largestIsland = new LargestIslandofOnes();
		for(Coordinates co : largestIsland.getLargestIsland()){
			System.out.println("(" + co.x +"," + co.y +")");
		}
	}
	
	public List<Coordinates> getLargestIsland(){
		List<Coordinates> largestIsland = new LinkedList<Coordinates>();
		for(int i = 0 ; i < islands.length;i++){
			for(int j = 0; j < islands[i].length; j++){
				if(islands[i][j] == 1){
					List<Coordinates> currentIsland = DFS(i,j, new LinkedList<Coordinates>());
					if(currentIsland.size() > largestIsland.size()){
						largestIsland = currentIsland;
					}
				}
			}
		}
		return largestIsland;
	}
	
	public List<Coordinates> DFS(int x, int y, List<Coordinates> currentIsland){
		for(Coordinates o : getNeighbours(x, y)){
			if(islands[o.x][o.y] == 1){
				islands[o.x][o.y] = 2;//mark it visited
				currentIsland.add(o);
				DFS(o.x, o.y,currentIsland);
			}
		}
		return currentIsland;
	}
	
	public List<Coordinates> getNeighbours(int x , int y){
		List<Coordinates> neighbours = new ArrayList<Coordinates>();
		if(x+1 < islands.length)
			neighbours.add(new Coordinates(x+1, y));
		if(x-1 >= 0)
			neighbours.add(new Coordinates(x-1, y));
		if(y+1 < islands[0].length)
			neighbours.add(new Coordinates(x, y+1));
		if(y-1 >= 0)
			neighbours.add(new Coordinates(x, y-1));
		return neighbours;
	}	
}