package backjoon.backTracking;

import java.util.*;

public class NandM_2 {
    static boolean[] visited;
    static int[] array;
    static int M, N;
    
    public static void dfs(int at, int depth) {
		
        if(depth == M) {
            /*
             깊이가 M이랑 같을경우 출력
            */
        }
        
        /*
         i 는 at 부터 탐색하도록 한다.
        */
        for(int i = at; i <= N; i++) {
            // 현재 깊이를 index로 하여 해당 위치에 i 값을 담는다
            array[depth] = i;
            
            /*
             재귀호출 :
             현재 i 값보다 다음 재귀에서 더 커야하므로
             i + 1 의 값을 넘겨주고, 깊이 또한 1 증가시켜 재귀호출해준다
            */
            dfs(i + 1, depth + 1);
        }
        
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        visited = new boolean[N];
        array = new int[M];

        dfs(1, 0);
        
    }
}
