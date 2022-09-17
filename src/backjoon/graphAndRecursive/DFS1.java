package backjoon.graphAndRecursive;

import java.util.Scanner;

public class DFS1 {
    static int[][] graph;
    static boolean[] visited;
    static int N,M,R;
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        //입력
        N = sc.nextInt();   //정점의 수
        M = sc.nextInt();   //간선의 수
        R = sc.nextInt();   //시작 정점

        visited = new boolean[N+1];
        graph = new int[N+1][N+1];
        for(int i=0;i<M;i++){   //간선 정보
            int u = sc.nextInt();
            int v = sc.nextInt();

            graph[u][v] = 1;
            graph[v][u] = 1;
        }
        //====== 출력 ======
        dfs(1);
    }


    public static void dfs(int node){
        visited[node] = true;
        System.out.println(node);

        if(node==0) return;

        boolean check = false;
        for(int i=1;i<graph[node].length;i++){
            if(!visited[i]){
                int nextNode = i;

                if(graph[node][nextNode]==1) {
                    check = true;
                    dfs(nextNode);
                }
                if(i==graph[node].length-1 && !check) dfs(0);
            }
        }        
    }
}



/*
    dfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
        visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
        for each x ∈ E(R)  # E(R) : 정점 R의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
            if (visited[x] = NO) then dfs(V, E, x);
    }
*/