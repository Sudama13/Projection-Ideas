import java.util.*;

public class NQueensBacktracking {
    public static boolean isSafe(int row , int col , char [][]board){
        //vertical
        for(int i = 0; i < board.length; i++) {
            if(board[i][col] == 'Q') {
                return false;
            }
        }
        //horizontal
        for(int j = 0; j < board.length; j++) {
            if(board[row][j] == 'Q') {
                return false;
            }
        }
        //upper left
        int r = row;
        for(int c = col; c >=0 && r >=0 ; r--,c--) {
            if(board[r][c] == 'Q'){
                return false;
            }
        }
        //upper right
        for(int c = col; r>=0 && c > board.length; r--,c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        //lower left
        for(int c = col; r< board.length && c >=0 ; r++, c--) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        //lower right
        for(int c = col; c < board.length && r < board.length ; r++,c++) {
            if(board[r][c] == 'Q') {
                return false;
            }
        }
        return true;
    }
    public static void saveboard(char[][] board , List<List<String>>AllBoard) {
        List<String> newBoard = new ArrayList<>();
        String row = " ";
        for(int i = 0; i <= board.length; i++) {
            for(int j = 0; j <=board[0].length; j ++) {
                if (board[i][j] == 'Q') {
                    row += 'Q';
                } else {
                    row += '.';
                }
            }
                newBoard.add(row);
            }
        AllBoard.add(newBoard);
        }
    public static void helper(char[][] board , List<List<String>>AllBoard , int col) {
        if(col == board.length) {
            saveboard(board , AllBoard);
            return;
        }
        for(int row =0; row <= board.length; row++) {
            if(isSafe(row , col , board)) {
                board[row][col] = 'Q';
                helper(board , AllBoard , col +1);
                board[row][col] = '.';
            }
        }
    }

    public static List<List<String>> Backtracking(int n) {
        List<List<String>> AllBoard = new ArrayList<>();
        char[][] board = new char[n][n];
        helper(board , AllBoard , 0);
        return AllBoard;
    }
}
