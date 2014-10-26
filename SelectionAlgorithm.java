package Random;

public class SelectionAlgorithm {
	static int[] data = {9,5,20,23,-17,40,2,82,-20,41,50,-27,30,-6};
	static int rank = 8; //5th highest number
	
	public static void main(String args[]){
	   System.out.println(elementAtGivenRank(rank, 0, data.length-1));
	}
	
	public static int elementAtGivenRank(int rank, int st, int end){
		int rankofPivot = positionOfPivot(st, end);
		if(rank == rankofPivot){
			return data[data.length-rankofPivot];
		}else if(rank < rankofPivot){//means u want a higher number so it should be on right
			return elementAtGivenRank(rank, rankofPivot+1, end);
		}else{
			return elementAtGivenRank(rank-rankofPivot, st, rankofPivot-1);
		}
	}
	
	public static int positionOfPivot(int st,int ed){
		int pivot = data[st];
		int pos = st+1;
		for(int i=st+1; i<=ed; i++){
			if(data[i]<pivot){
				swap(i,pos);
				pos++;
			}
		}
		swap(pos-1,st);
		return (ed-st+1)-(pos-1);
	}
	
	public static void swap(int a, int b){
		int temp = data[a];data[a] = data[b]; data[b] = temp;
	}
}
