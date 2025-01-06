package mapnsets;

import java.util.HashSet;
import java.util.Set;

public class SudokuVerify {
    public static void main(String[] args) {
        char board[][] = {
                  {'5', '3', '.', '.', '7', '7', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        char board1[][] = {
                  {'5', '3', '.', '.', '7', '.', '9', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(isValidSudoku(board));
        System.out.println(isValidSudoku(board1));
    }

    public static boolean isValidSudoku(char[][] board) {
        HashSet<Character>[] rowSet = new HashSet[9];
        HashSet<Character>[] colSet = new HashSet[9];
        HashSet<Character>[] subGrids = new HashSet[9];

        for (int i = 0; i < 9; i++) {
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            subGrids[i] = new HashSet<>();
        }

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char c = board[row][col];

                if (c == '.') {
                    continue;
                }

                int index = (row / 3) * 3 + (col / 3);
                if (rowSet[row].contains(c) || colSet[col].contains(c) || subGrids[index].contains(c)) {
                    return false;
                }

                rowSet[row].add(c);
                colSet[col].add(c);
                subGrids[index].add(c);
            }
        }

        return true;
    }
}
