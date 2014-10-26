package Random;

import java.util.LinkedList;
import java.util.Queue;

class Point{
	int x,y,z;
	int color;

	public Point(int x, int y , int z , int color){
		this.x = x; this.y = y; this.z = z; this.color = color;
	}
}

public class LightCube {
	int answer[];
	public static void main(String args[]){
		LightCube lc = new LightCube();
		String lights[] = {"29 13 9", "4 10 34", "11 26 16", "2 33 22", "27 31 14", "36 20 8"};
		lc.count(40, lights);
	}

	public void count(int N, String[] lights){
		Queue<Point> initialPoints = new LinkedList<Point>();
		answer = new int[lights.length + 1];
		for(int i = 1 ; i < answer.length; i++){
			answer[i]=1;
		}

		//init cube
		Point lightCube[][][] = new Point[N][N][N];
		for (int i=0; i<lights.length; i++){
			int intPoint[] = convertStringToPoint(lights[i]);
			lightCube[intPoint[0]][intPoint[1]][intPoint[2]] = 
					new Point(intPoint[0],intPoint[1],intPoint[2],i+1);
			initialPoints.add(lightCube[intPoint[0]][intPoint[1]][intPoint[2]]);
		}

		while(initialPoints.size()!=0){
			initialPoints = update(N, lightCube, initialPoints);
		}

		for(int i : answer){
			System.out.print(i + " ");
		}
	}

	public Queue<Point> update(int N, Point[][][] lightCube, Queue<Point> initialPoints){
		Queue<Point> tmpQueue = new LinkedList<>();
		Queue<Point> neighbours = new LinkedList<>();

		for(Point initalPoint : initialPoints){
			neighbours = getNeighbours(N, initalPoint,lightCube);
			for(Point neighbour : neighbours){
				if(neighbour.color == 0){
					neighbour.color = initalPoint.color;
					lightCube[neighbour.x][neighbour.y][neighbour.z] = neighbour;
					tmpQueue.add(neighbour);
					answer[initalPoint.color]++;
				}
			}
		}
		return tmpQueue;
	}

	public int[] convertStringToPoint(String point){
		String points[] = point.split(" ");
		int x = Integer.parseInt(points[0]), y = Integer.parseInt(points[1]), z = Integer.parseInt(points[2]); 
		int intPoint[]={x,y,z};
		return intPoint;
	}

	public Queue<Point> getNeighbours(int N, Point point , Point lightCube[][][]){
		Queue<Point> neighbours = new LinkedList<>();
		int x = point.x, y = point.y, z = point.z;
		if(x-1 >= 0){
			Point p1 = null;
			if(lightCube[x-1][y][z]==null){
				p1 = new Point(x-1,y,z, 0);
			}else{
				p1 = new Point(x-1,y,z,lightCube[x-1][y][z].color);
			}
			neighbours.add(p1);
		}
		if(x+1 < N){
			Point p2 = null;
			if(lightCube[x+1][y][z]==null){
				p2 = new Point(x+1,y,z, 0);
			}else{
				p2 = new Point(x+1,y,z,lightCube[x+1][y][z].color);
			}
			neighbours.add(p2);
		}
		if(y-1 >= 0){
			Point p3 = null;
			if(lightCube[x][y-1][z]==null){
				p3 = new Point(x,y-1,z, 0);
			}else{
				p3 = new Point(x,y-1,z,lightCube[x][y-1][z].color);
			}
			neighbours.add(p3);
		}
		if(y+1 < N){
			Point p4 = null;
			if(lightCube[x][y+1][z]==null){
				p4 = new Point(x,y+1,z, 0);
			}else{
				p4 = new Point(x,y+1,z,lightCube[x][y+1][z].color);
			}
			neighbours.add(p4);
		}
		if(z-1 >= 0){
			Point p5 = null;
			if(lightCube[x][y][z-1]==null){
				p5 = new Point(x,y,z-1, 0);
			}else{
				p5 = new Point(x,y,z-1,lightCube[x][y][z-1].color);
			}
			neighbours.add(p5);
		}
		if(z+1 < N){
			Point p6 = null;
			if(lightCube[x][y][z+1]==null){
				p6 = new Point(x,y,z+1, 0);
			}else{
				p6 = new Point(x,y,z+1,lightCube[x][y][z+1].color);
			}
			neighbours.add(p6);
		}
		return neighbours;
	}
}