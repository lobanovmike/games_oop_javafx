package ru.job4j.puzzle;

public class Win {
    public static boolean check(int[][] board) {
        return checkHorizontal(board) || checkVertical(board);
    }

    public static boolean checkVertical(int[][] board) {
        boolean result = true;
        int pos = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == 1) {
                pos = i;
                break;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[i][pos] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }

    public static boolean checkHorizontal(int[][] board) {
        boolean result = true;
        int pos = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == 1) {
                pos = i;
                break;
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (board[pos][i] != 1) {
                result = false;
                break;
            }
        }
        return result;
    }
}
