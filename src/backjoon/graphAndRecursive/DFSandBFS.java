package backjoon.graphAndRecursive;

import java.util.*;
import java.io.*;

public class DFSandBFS {
    static Queue<Integer> answer = new LinkedList<>();
    static ArrayList<Integer>[] adj;
    static boolean[] visited;
    static int N,M,V, cost;
    
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());   

        adj = new ArrayList[N+1];
        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            adj[a].add(b);
            adj[b].add(a);
        }

        for(int i=0;i<adj.length;i++){
            Collections.sort(adj[i]);
        }

        Stack<Integer> stack = new Stack<>();
        answer.offer(V);
        visited = new boolean[N+1];
        visited[V] = true;
        cost = 1;
        stack.add(V);
        dfs(stack, cost);

        while(!answer.isEmpty()){
            int node = answer.poll();
            System.out.print(node+" ");
        }
        System.out.println();

        Queue<Integer> queue = new LinkedList<>();
        answer.offer(V);
        visited = new boolean[N+1];
        visited[V] = true;
        cost = 1;
        queue.offer(V);
        bfs(queue, cost);

        while(!answer.isEmpty()){
            int node = answer.poll();
            System.out.print(node+" ");
        }
        System.out.println();
    }


    public static void dfs(Stack<Integer> stack, int cost){
        if(cost==N) return;
        else{
            int node = stack.pop();

            for(int nextNode : adj[node]){
                if(!visited[nextNode]){
                    visited[nextNode] = true;

                    answer.offer(nextNode);
                    stack.push(nextNode);
                    dfs(stack, cost);
                }
            }
        }
    }

    public static void bfs(Queue<Integer> queue, int cost){
        if(cost==N) return;
        else{

            while(!queue.isEmpty()){
                int node = queue.poll();

                for(int nextNode : adj[node]){
                    if(!visited[nextNode]){
                        visited[nextNode] = true;

                        answer.offer(nextNode);
                        queue.offer(nextNode);
                    }
                }
            }

        }

    }
}



/*
 * 
 * DFS와 BFS 실패
시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
2 초	128 MB	199068	73164	43379	35.779%
문제
그래프를 DFS로 탐색한 결과와 BFS로 탐색한 결과를 출력하는 프로그램을 작성하시오. 
단, 방문할 수 있는 정점이 여러 개인 경우에는 정점 번호가 작은 것을 먼저 방문하고, 더 이상 방문할 수 있는 점이 없는 경우 종료한다. 
정점 번호는 1번부터 N번까지이다.

입력
첫째 줄에 정점의 개수 N(1 ≤ N ≤ 1,000), 간선의 개수 M(1 ≤ M ≤ 10,000), 탐색을 시작할 정점의 번호 V가 주어진다. 
다음 M개의 줄에는 간선이 연결하는 두 정점의 번호가 주어진다. 
어떤 두 정점 사이에 여러 개의 간선이 있을 수 있다. 
입력으로 주어지는 간선은 양방향이다.

출력
첫째 줄에 DFS를 수행한 결과를, 그 다음 줄에는 BFS를 수행한 결과를 출력한다. 
V부터 방문된 점을 순서대로 출력하면 된다.

입력
4 5 1
1 2
1 3
1 4
2 4
3 4
출력
1 2 4 3
1 2 3 4
 * 
 */