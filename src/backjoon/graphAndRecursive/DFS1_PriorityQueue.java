package backjoon.graphAndRecursive;

import java.util.*;
import java.io.*;

public class DFS1_PriorityQueue {
    static PriorityQueue<Integer>[] adj;    //문제 조건이 정점의 오름차순이기에 priorityQueue 사용.
    static boolean[] visited;
    static int[] cntArr;
    static int N,M,R, cost;

    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        adj = new PriorityQueue[N+1];
        visited = new boolean[N+1];
        cntArr = new int[N+1];

        for (int i=0;i<=N;i++) {
            adj[i] = new PriorityQueue<Integer>();
        }

        for (int i=0;i<M;i++) {
            st = new StringTokenizer(br.readLine()," ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adj[u].offer(v);
            adj[v].offer(u);
        }

        cost = 0;
        dfs(R);

        for (int i = 1; i <= N ; i++) {
            System.out.println(cntArr[i]);
        }
    }

    public static void dfs(int node){
        visited[node] = true;
        cntArr[node] = ++cost;

        while(!adj[node].isEmpty()){
            int nextNode = adj[node].poll();

            if(!visited[nextNode]) dfs(nextNode);

        }
    }
}
// 1 2  
// 2 3
// 
// 1 2
// 1 2 3
// 2 3


/* 
5 5 2
1 4
1 2
2 3
2 4
3 4
    
# Output
2
1
3
4
0
    
# Answer
2
1
4
3
0
====
input:
5 2 2
1 2
2 3

answer:
2
1
3
0
0

output:
2
1
2
0
0

2 1 1
2 1
정답:
1
2
출력:
1
0

*/