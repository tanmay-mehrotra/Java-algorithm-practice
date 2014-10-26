package Random;


public class ChampagneSolution {
	public static float glasses[];

	public static float howMuch(int ht, int gl,int ut){
		glasses = new float[(ht*(ht+1))/2 + 1];
		int level = 1;
		glasses[1] = ut;
		while(level <= ht-1 && ut > 0){
			int startPointofALevel = level*(level-1)/2 + 1;
			for (int i = startPointofALevel ; i < startPointofALevel+level ; i++){	
				if (glasses[i]< 2)
					continue;
				else{
					if(level == ht-1){
						glasses[i+level] = Math.min(2,glasses[i+level] + (glasses[i]-2)/2);
						glasses[i+level+1] = Math.min(2,glasses[i+level+1] + (glasses[i]-2)/2);
					}
					else{
						glasses[i+level] += (glasses[i]-2)/2;
						glasses[i+level+1] += (glasses[i]-2)/2;
					}
					glasses[i]=2;
				}
			}
			level++;
		}
		return glasses[gl]/2;
	}	

	
	public static void main(String args[]){
		System.out.println(ChampagneSolution.howMuch(20, 204,300));	
	}
}
