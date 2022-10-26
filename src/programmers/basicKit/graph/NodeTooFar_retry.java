package programmers.basicKit.graph;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;



public class NodeTooFar_retry {
    public int solution(int n, int[][] edge) {
        LinkedList<Integer>[] adj = new LinkedList[n+1];
        boolean[] visited = new boolean[n+1];
        int[] cost = new int[n+1];
        int answer = 0;

        for(int i=0;i<=n;i++){
            adj[i] = new LinkedList<Integer>();
        }

        for(int i=0;i<edge.length;i++){
            int a = edge[i][0];
            int b = edge[i][1];

            adj[a].add(b);
            adj[b].add(a);
        }

        cost = bfs(adj, visited, cost);
        Arrays.sort(cost);

        int max = cost[cost.length-1];
        for(int i=0;i<cost.length;i++){
            if(cost[i]==max) ++answer;
        }
        return answer;
    }

    public int[] bfs(LinkedList<Integer>[] adj, boolean[] visited, int[] cost){
        Queue<Integer> queue = new LinkedList();
        visited[1] = true;
        queue.offer(1);

        while(!queue.isEmpty()){
            int node = queue.poll();

            while(!adj[node].isEmpty()){
                int nextNode = adj[node].poll();

                if(!visited[nextNode]){
                    visited[nextNode] = true;
                    cost[nextNode] = cost[node]+1;

                    queue.offer(nextNode);
                }
            }
        }

        return cost;
    }
}
