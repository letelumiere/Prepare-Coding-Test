package backjoon.graphAndRecursive;

import java.util.*;
import java.io.*;

public class BFS1 {
    static PriorityQueue<Integer>[] adj;
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
        

        Queue<Integer> queue = new LinkedList<>();

        cost = 1;
        cntArr[R] = cost;
        visited[R] = true;
        queue.offer(R);

        bfs(queue);
        
        for (int i = 1; i <= N ; i++) {
            System.out.println(cntArr[i]);
        }
    }

    public static void bfs(Queue<Integer> queue){        
        while(!queue.isEmpty()){
            int node = queue.poll();

            while(!adj[node].isEmpty()){
                int nextNode = adj[node].poll();

                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    cntArr[nextNode] = ++cost;

                    queue.offer(nextNode);
                }
            }
        }

    }            
}




/*

너비 우선 탐색 의사 코드는 다음과 같다. 인접 정점은 오름차순으로 방문한다.

bfs(V, E, R) {  # V : 정점 집합, E : 간선 집합, R : 시작 정점
    for each v ∈ V - {R}
        visited[v] <- NO;
    visited[R] <- YES;  # 시작 정점 R을 방문 했다고 표시한다.
    enqueue(Q, R);  # 큐 맨 뒤에 시작 정점 R을 추가한다.
    while (Q ≠ ∅) {
        u <- dequeue(Q);  # 큐 맨 앞쪽의 요소를 삭제한다.
        for each v ∈ E(u)  # E(u) : 정점 u의 인접 정점 집합.(정점 번호를 오름차순으로 방문한다)
            if (visited[v] = NO) then {
                visited[v] <- YES;  # 정점 v를 방문 했다고 표시한다.
                enqueue(Q, v);  # 큐 맨 뒤에 정점 v를 추가한다.
            }
    }
}
입력
첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.

다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다. (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.

출력
첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다. 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.
5 5 1
1 4
1 2
2 3
2 4
3 4

1
2
4
3
0
 */