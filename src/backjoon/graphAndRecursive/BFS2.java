package backjoon.graphAndRecursive;
import java.util.*;
import java.io.*;


public class BFS2 {
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
            adj[i] = new PriorityQueue<Integer>(Collections.reverseOrder());
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
