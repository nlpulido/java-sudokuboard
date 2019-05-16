import java.util.Random;

public class Sudoku {

	int board[][] = new int[9][9];
	int size = 0;

	public static void main(String args[]){
		Sudoku sudoku = new Sudoku();


		if (sudoku.fillBoard()){
			sudoku.printBoard();
		}
	}

	public boolean fillBoard(){
		return this.fillBoard(0, 0);
	}

	public boolean fillBoard(int row, int col){
		Random rand = new Random();
		int cand = rand.nextInt(8) + 1;
		int attempts = 0;

		if (col > 8){
			return fillBoard(row + 1, 0);
		}

		if (row > 8){
			return true;
		}			

		while(attempts < 9){
			if (isValid(row, col, cand) == true){
				board[row][col] = cand;
				if (fillBoard(row, col + 1) == true){
					return true;
				}
				board[row][col] = 0; 
				}
			cand++;
			if (cand == 10)
				cand = 1;
			attempts++;
		}

		return false;
	}

	public boolean isValid(int row, int col, int cand){
		// checks if candidate exists in the column
		for (int i = 0; i < 9; i++){
			if (board[i][col] == cand){
				return false;
			}

		}

		// checks if candidate exists in the row
		for (int j = 0; j < 9; j++){
			if (board[row][j] == cand){
				return false;
			}
		}

		// check here if candidate exists in the box; NEED TO COMPLETE
		for (int k = (row - (row % 3)); k < (row - (row % 3) + 3); k++){
			for (int l = (col - (col % 3)); l < (col - (col % 3)+ 3); l++){
				if (board[k][l] == cand){
					return false;
				}
			}
		}

		return true;
	}

	public void printBoard(){
		System.out.println(" -----------------------");
		for (int i = 0; i < 3; i++){
			System.out.print("| ");
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			for (int j = 3; j < 6; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			for (int j = 6; j < 9; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println("| ");
		}
		System.out.println(" -----------------------");
		for (int i = 3; i < 6; i++){
			System.out.print("| ");
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			for (int j = 3; j < 6; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			for (int j = 6; j < 9; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println("| ");
		}
		System.out.println(" -----------------------");
		for (int i = 6; i < 9; i++){
			System.out.print("| ");
			for (int j = 0; j < 3; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			for (int j = 3; j < 6; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.print("| ");
			for (int j = 6; j < 9; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println("| ");
		}
		System.out.println(" -----------------------");
	}
}