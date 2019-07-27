package Recursion;

public class Backtracking {
	public static void main(String[] arg) {
		//int[][] maze = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		//blockedMazePath(maze, 0, 0, new boolean[3][3], "");
		Nqueen(new boolean[4][4],0,"");

	}

	public static void blockedMazePath(int[][] maze, int cr, int cc, boolean[][] visited, String ans) {
		if (cr == maze.length - 1 && cc == maze[0].length - 1) {
			System.out.println(ans);
			return;
		}
		if (cr > maze.length - 1 || cc > maze[0].length - 1 || cc < 0 || cr < 0 || visited[cr][cc] == true
				|| maze[cr][cc] == 1) {
			return;
		}
		visited[cr][cc] = true;
		blockedMazePath(maze, cr, cc + 1, visited, ans + "R");
		blockedMazePath(maze, cr + 1, cc, visited, ans + "D");
		blockedMazePath(maze, cr - 1, cc, visited, ans + "T");
		blockedMazePath(maze, cr, cc - 1, visited, ans + "L");
		visited[cr][cc] = false;
	}

	public static void Nqueen(boolean[][] board, int row, String ans) {
		if (row == board.length) {
			System.out.println(ans);
			return;
		}
		for (int col = 0; col < board[0].length; col++) {

			if (isItSafe(board, row, col)) {
				board[row][col]=true;
				Nqueen(board, row + 1, ans + "{" + row + "," + col + "}");
				board[row][col]=false;
			}
		}

	}
	public static boolean isItSafe(boolean[][] board,int row,int col) {
		//for up
		int c=col;
		int r=row-1;
		while(r>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
		}
		// for diagonally left
		c=col-1;
		 r=row-1;
		while(r>=0 && c>=0) {
			if(board[r][c]) {
				return false;
			}
			r--;
			c--;
		}
		// for diagonally right
		c=col+1;
		 r=row-1;
		while(r>=0 && c<board[0].length) {
			if(board[r][c]) {
				return false;
			}
			r--;
			c++;
		}
		return true;
		
	}

}
