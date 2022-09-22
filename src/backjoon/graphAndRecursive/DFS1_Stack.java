package backjoon.graphAndRecursive;

import java.util.*;
import java.io.*;

public class DFS1_Stack {
    static Stack<Integer>[] adj;    //아직 구현 안함
    static int[] cntArr;
    static boolean[] visited;
    static int N,M,R;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new Stack[N+1];
        visited = new boolean[N+1];
        cntArr = new int[N+1];

        for (int i=0;i<=N;i++) {
            adj[i] = new Stack<Integer>();
        }
        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].push(v);
            adj[v].push(u);
        }

        dfs(R, 1);
        for(int i=0;i<cntArr.length;i++){
            System.out.println(cntArr[i]);
        }
    }

    public static void dfs(int node, int cost){
        visited[node] = true;
        cntArr[node] = cost;

        while(!adj[node].isEmpty()){
            int nextNode = adj[node].pop();
            if(!visited[nextNode]) dfs(nextNode, cost+1);
        }
    }
}

