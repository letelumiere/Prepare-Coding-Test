package backjoon.graphAndRecursive;

import java.io.*;
import java.util.*;

public class PutNumber {
    static int[][] map;
    static boolean[][] visited;
    static int count, qty;
    static PriorityQueue<Integer> queue = new PriorityQueue<>();
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //====== 입력 =====
        int N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        
        for(int i=0;i<N;i++){
            String numbers = br.readLine();
            for(int j=0;j<numbers.length();j++){
                map[i][j] = numbers.charAt(j)-48;
            }
        }
        //===== 인접행렬 방문 알고리즘 =====

        for(int i=0;i<N;i++){
            for(int j=0;j<N;j++){
                if(map[i][j]>0 && !visited[i][j]) {
                    ++count;
                    qty = 0;
                    dfs(i, j);
                    queue.offer(qty);
                }
            }
            
        }

        System.out.println(count);
        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

        br.close();
        bw.close();
    }

    public static void dfs(int x, int y){
        if((x<0 || x==map.length) || (y<0 || y==map.length)) return;
        if(map[x][y]==0 || visited[x][y]) return;

        visited[x][y] = true;
        ++qty;
        dfs(x+1, y);
        dfs(x, y+1);
        dfs(x-1, y);
        dfs(x, y-1);    
    }
}


    //dfs(모든 경우의 수니까)
    
    //시작점 체크
    //0, 0에서 시작한다. //대각선으로 시작점 좌표가 증가한다
        //시작점 좌표 기준으로 위에서 아래, 왼->우
            //해당 좌표가 0이면 continue;
            //else 시작
                //해당 좌표가 visited면 continue;
                //else면 dfs(단지 범위 체크)
        //해당 지점의 dfs가 끝나면 count누적 저장


    //dfs의 순회 제한조건
        //if map의 length()에서 벗어날 때
        //if map[n][n]이 0일때 1일때. 
        //if map[n]이 ++;
        //인접 상하좌우가 0일 때
