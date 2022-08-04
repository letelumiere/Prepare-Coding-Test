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
/*
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
BBBBBBBBWBWBW
BBBBBBBBBWBWB
WWWWWWWWWWBWB
WWWWWWWWWWBWB
 */


 /*
  * 

체스판은 검은색과 흰색이 번갈아서 칠해져 있어야 한다. 구체적으로, 각 칸이 검은색과 흰색 중 하나로 색칠되어 있고, 변을 공유하는 두 개의 사각형은 다른 색으로 칠해져 있어야 한다. 따라서 이 정의를 따르면 체스판을 색칠하는 경우는 두 가지뿐이다. 하나는 맨 왼쪽 위 칸이 흰색인 경우, 하나는 검은색인 경우이다.

보드가 체스판처럼 칠해져 있다는 보장이 없어서, 지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다. 당연히 8*8 크기는 아무데서나 골라도 된다. 지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.

출력
첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
  */