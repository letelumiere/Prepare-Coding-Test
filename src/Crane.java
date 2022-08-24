import java.util.Stack;

public class Crane {
    
    public int solution(int[][] board, int[] moves) {
        Stack<Integer> picked = new Stack();
        int answer = 0;

        for(int i=0;i<moves.length;i++){
            int n = moves[i]-1;

            for(int j=0;j<board.length;j++){
                if(board[j][n]>0){
                    picked.push(board[j][n]); 
                    board[j][n] = 0;
                    break;
                }
            }

            if(picked.size()>1) {
                int p = picked.pop();
                if(p==picked.peek()){
                    picked.pop();
                    answer+=2;
                }else{
                    picked.push(p);
                }
            }
        }
        
        return answer;
    }
}



/*
    //move => for 반복문

    int crane = 0;
    //picked<stack>
        if(picked.peek()==crane) picked.pop();
        else picked.poll(crane);

    //board
        for(int i=0;i<board.length;i++){
            if(board[i]!=0) crane = board[i];
                            board[i] = 0;
        }
    ]
    answer++;   <- 터질 때 마다

 
 */

/*
 board	moves	result
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4
 */