package Random;;

public class NQueens {
	static int board[] = new int[4];
	public static void main(String args[]){
		nQueens(0);
	}

	public static void nQueens(int r){
		if(r == 4){
			System.out.println("Results:");
			for(int value:board)
				System.out.println(value);
			return;
		}    	
		for(int i = 0;i<=3;i++){
			if(canPlace(r,i)){
				board[r]=i;
				nQueens(r+1);
			}
		}
	}

	public static boolean canPlace(int r, int c){
		if(r==0)
			return true;
		for(int i = 0 ; i <=r-1; i++){
			if (board[i] == c || Math.abs(board[i]-c)==Math.abs(r-i))
				return false;
		}
		return true;
	}
}