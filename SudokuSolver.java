package Random;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SudokuSolver {
	static int board[][] = new int[9][9];

	public static void main(String args[]){

		inputPuzzle();
		System.out.println("Input puzzle");
		displayBoard();
		solve(0,0);
	}

	public static void inputPuzzle(){
		BufferedReader br = null;
		try {
			String sCurrentLine;
			br = new BufferedReader(new FileReader("/Users/tanmaymehrotra/Desktop/Sudoku.txt"));
			int row = 0;
			while ((sCurrentLine = br.readLine()) != null) {
				for(int i  = 0 ; i <9;i++){
					board[row][i]= sCurrentLine.charAt(i)-'0';
				}
				row++;
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} 	
	}

	public static void displayBoard(){
		for(int i=0;i<board.length;i++){
			for(int j=0;j<board[0].length;j++){
				System.out.print(board[i][j]+ " ");
			}
			System.out.println();
		}	
	}

	public static void solve(int r, int c){
		if(r == 9){
			System.out.println("solved puzzle");
			displayBoard();
			return;
		}
		if(c == 9){
			solve(r+1,0);
			return;
		}
		if(board[r][c]!=0){
			solve(r,c+1);
			return;
		}
		for(int i = 1; i <= 9; i++){
			if(islegal(i,r,c)){
				board[r][c] = i;
				solve(r,c+1);
			}
		}
		board[r][c]=0;
	}

	public static boolean islegal(int value, int r, int c){

		for(int i =0 ;i<9;i++){
			if(i == r)
				continue;
			if(board[i][c]==value)
				return false;
		}

		for(int j=0 ;j<9;j++){
			if(j == c)
				continue;
			if(board[r][j]==value)
				return false;
		}

		int br = r/3 * 3;
		int cr = c/3 * 3;
		for( int i = br; i<br+3; i++){
			for(int j = cr; j<cr+3;j++){
				if(board[i][j]==value)
					return false;
			}
		}
		return true;
	}
}