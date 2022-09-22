package backjoon.graphAndRecursive;

import java.io.*;
import java.util.*;


class Node {
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Maze {
    static int[][] direction = {{1,0},{0,1},{-1,0},{0,-1}};
    static int[][] adj;
    static boolean[][] visited;
    static int M, N;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //====== 입력 =====

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken(" "));
        M = Integer.parseInt(st.nextToken(" "));
            
        adj = new int[N][M];
        visited = new boolean[N][M];
        Queue<Node> queue = new LinkedList();

        for(int i=0;i<N;i++){
            String numbers = br.readLine();
            
            for(int j=0;j<numbers.length();j++){
                adj[i][j] = numbers.charAt(j)-'0';
            }
        }
        visited[0][0] = true;
        queue.offer(new Node(0, 0));
        
        bfs(queue);
        System.out.println(adj[N-1][M-1]);
        


        br.close();
        bw.close();
    }

    public static boolean position(int nx, int ny, int width, int height){
        if((0<=nx && nx<width) && (0<=ny && ny<height)) return true;
        return false;
    }

    public static void bfs(Queue<Node> queue){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.x==N-1 && node.y==M-1) break;

            for(int i=0;i<direction.length;i++){
                int nx = node.x+direction[i][0];
                int ny = node.y+direction[i][1];

                if(position(nx, ny, N, M) && adj[nx][ny]==1){
                    if(!visited[nx][ny]){
                        
                        visited[nx][ny] = true;
                        queue.offer(new Node(nx, ny));
                    }

                }
            }
        }               
    }
}