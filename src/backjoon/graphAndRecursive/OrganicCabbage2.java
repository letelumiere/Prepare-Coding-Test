package backjoon.graphAndRecursive;


import java.io.*;
import java.util.*;

class Node{
    int x;
    int y;
    
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
    @Override
    public String toString() {
        return "Node [x=" + x + ", y=" + y + "]";
    }
    
    public static boolean position(int nx, int ny, int width, int height){
        if((0<=nx && nx<width) && (0<=ny && ny<height)) return true;
        return false;
    }
}

public class OrganicCabbage2 {
    static boolean[][] visited;
    static int[][] adj;
    static int[][] wasd = {{0,1},{1,0},{0,-1},{-1,0}};
    static int[] count;
    static int M, N, K;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //====== 입력 =====
        int T = Integer.parseInt(br.readLine());   
        count = new int[T];

        StringTokenizer st;
        for(int i=0;i<T;i++){
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken(" "));
            N = Integer.parseInt(st.nextToken(" "));
            K = Integer.parseInt(st.nextToken(" "));    
            
            adj = new int[M][N];
            visited = new boolean[M][N];

            for(int j=0;j<K;j++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken(" "));
                int Y = Integer.parseInt(st.nextToken(" "));

                adj[X][Y] = 1;
            }

            //탐색
            Stack<Node> stack = new Stack<>();
            for(int a=0;a<adj.length;a++){
                for(int b=0;b<adj[a].length;b++){
                    if(adj[a][b]==1 && !visited[a][b]){
                        ++count[i];
                        stack.add(new Node(a,b));
                        dfs(stack);
                    }
                }
            }
        }
        
        for(int cnt : count) System.out.println(cnt);

        br.close();
        bw.close();
    }

    public static void dfs(Stack<Node> stack){
        if(stack.isEmpty()) return;
        else{
            Node node = stack.pop();
            if(adj[node.x][node.y]==0 || visited[node.x][node.y]) return;
            else{
                visited[node.x][node.y] = true;

                for(int i=0;i<wasd.length;i++){
                    int nx = node.x+wasd[i][0];
                    int ny = node.y+wasd[i][1];
    
                    if(node.position(nx, ny, M, N)) {
                        stack.push(new Node(nx, ny));
                        dfs(stack);
                    }
                }
            }
        }
    }
}

