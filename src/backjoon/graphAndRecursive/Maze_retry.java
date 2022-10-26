package backjoon.graphAndRecursive;

import java.io.*;
import java.util.*;

public class Maze_retry {
    static int[][] direction = {{0,1},{1,0},{-1,0},{0,-1}};
    static boolean[][] visited;

    public static int solution(int[][] adj, int N, int M){
        visited = new boolean[N][M];        

        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(0, 0));


        return bfs(queue, adj, N, M);
    }

    public static int bfs(Queue<Node> queue, int[][] adj, int N, int M){
        while(!queue.isEmpty()){
            Node curNode = queue.poll();

            for(int i=0;i<direction.length;i++){
                int nx = curNode.x+direction[i][0];
                int ny = curNode.y+direction[i][1];

                if(direction(nx, ny, N, M) && status(nx, ny, adj)){
                    visited[nx][ny] = true;
                    adj[nx][ny] = adj[curNode.x][curNode.y]+1;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
        return adj[N-1][M-1];
    }

    public static boolean direction(int x, int y, int height, int width){
        return ((0<=x && x<height) && (0<=y && y<width));
    }

    public static boolean status(int x, int y, int[][] adj){
        return (adj[x][y]==1 && !visited[x][y]);
    }



    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //====== 입력 =====
    
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken(" "));
        int M = Integer.parseInt(st.nextToken(" "));
        int[][] adj = new int[N][M];

        for(int i=0;i<N;i++){
            String numbers = br.readLine();
    
            for(int j=0;j<numbers.length();j++){
                adj[i][j] = numbers.charAt(j)-'0';
            }
        }
        
        System.out.println(solution(adj, N, M));
    }
}

class Node{
    int x;
    int y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
