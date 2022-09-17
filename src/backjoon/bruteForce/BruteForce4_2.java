package backjoon.bruteForce;

import java.util.Scanner;

public class BruteForce4_2 {
    public static boolean[][] board;
    public static int min = 64;

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        board = new boolean[M][N];

        //입력 초기화
        for(int i=0;i<board.length;i++){
            String str = sc.next();

            for(int j=0;j<board[i].length;j++){
                if(str.charAt(j)=='W') board[i][j] = true;
                else board[i][j] = false;
            }
        }

        int row_limit = M-7;
        int column_limit = N-7;

        for(int i=0;i<row_limit;i++){
            for(int j=0;j<column_limit;j++){
                colorScan(i, j);
            }
        }

        System.out.println(min);
    }

    public static void colorScan(int x, int y){
        int x_limit = x+8;
        int y_limit = y+8;
        int count = 0;
        boolean check = board[x][y];

        for(int i=x;i<x_limit;i++){
            for(int j=y;j<y_limit;j++){
                if(board[i][j]!=check) ++count;
                check = (!check);
            }
            check = (!check);
        }


        count = Math.min(count, 64-count);
        min = Math.min(count, min);
    }
}