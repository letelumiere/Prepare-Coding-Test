package practice;

public class Solution2 {
    public int getMin(int min, int n){
        if(min>n){
            min = n;
        }
        return min;
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[][] board = new int[rows+1][columns+1];
        int[] answer = new int[queries.length];

        //queries 배열대로
        //힌트 - 즉, 아무 회전도 하지 않았을 때, i 행 j 열에 있는 숫자는 ((i-1) x columns + j)입니다.
        for(int i=0;i<queries.length;i++){
            int x1 = queries[i][0]; int y1 = queries[i][1];
            int x2 = queries[i][2]; int y2 = queries[i][3];

            int temp = board[x1][y1]; 
            int min = 0;

            if(temp==0) min = (x1-1)*columns+y1;
            else min = board[x1][y1];

            //1 left->right = (x1, y1) -> (x1, y2); 한칸씩
            for(int y=y1;y<y2;y++){
                if(board[x1][y]!=0){
                    int temp2 = board[x1][y];
                    board[x1][y] = temp;
                    temp = temp2;
                }else{
                    board[x1][y] = temp;
                    temp = (x1-1)*columns+y;
                }
                min = getMin(min, temp);

            }

            //2 up->down    = (x1, y2) -> (x2, y2);
            for(int x=x1;x<x2;x++){
                if(board[x][y2]!=0){
                    int temp2 = board[x][y2];
                    board[x][y2] = temp;
                    temp = temp2;
                }else{
                    board[x][y2] = temp;
                    temp = (x-1)*columns+y2;
                }
                min = getMin(min, temp);
            }

            //3 right->left = (x2, y2) -> (x2, y1);
            for(int y=y2;y>y1;y--){
                if(board[x2][y]!=0){
                    int temp2 = board[x2][y];
                    board[x2][y] = temp;
                    temp = temp2;
                }else{
                    board[x2][y] = temp;
                    temp = (x2-1)*columns+y;
                }
                min = getMin(min, temp);
            }

            //4 down->up    = (x2, y1) -> (x1, y1);
            for(int x=x2;x>=x1;x--){
                if(board[x][y1]!=0){
                    int temp2 = board[x][y1];
                    board[x][y1] = temp;
                    temp = temp2;
                }else{
                    board[x][y1] = temp;
                    temp = (x-1)*columns+y1;
                }
                min = getMin(min, temp);
            }
            answer[i] = min;
        }

        return answer;
    }
}

