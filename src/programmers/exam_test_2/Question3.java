package programmers.exam_test_2;

import java.util.HashMap;
import java.util.Stack;

public class Question3 {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        boolean[][] adj = new boolean[n+1][n+1]; 
        int[] answer = new int[sources.length];

        for(int i=0;i<roads.length;i++){
            int a = roads[i][0];
            int b = roads[i][1];

            adj[a][b] = adj[b][a] = true;
        }
        /* */
        for(int i=0;i<sources.length;i++){
            boolean[] visited = new boolean[n+1];
            int depth = 0;
            System.out.print(sources[i]);
            dfs2(visited, adj, sources[i], destination, depth);
            System.out.println();
        }


        return answer;
    }

    //간선 그래프(맞나) dfs
    public void dfs(boolean[] visited, boolean[][] adj, int nodeIdx, int destination, int depth){
        visited[nodeIdx] = true;
        if(nodeIdx==destination) {
            System.out.print("!"+"("+depth+")"+"\n");
            return;
        }else{
            for(int i=1;i<adj[nodeIdx].length;i++){
                if(visited[destination]==true) return;

                int nextNode = i;

                if(adj[nodeIdx][i]==true && visited[nextNode]==false) {
                    System.out.print(" => " +nextNode);
                    if(!visited[i]) dfs(visited, adj, nextNode, destination, depth+1);
                }
            }
        }
    }   

    //해당 문제의 조건을 충족하면서 dfs
    public void dfs2(boolean[] visited, boolean[][] adj, int nodeIdx, int destination, int depth){
        visited[nodeIdx] = true;
        if(nodeIdx==destination) {
            System.out.print("!"+"("+depth+")"+"\n");
            return;
        }else{
            if(adj[nodeIdx][destination]==true) {
                int nextNode = destination;
                System.out.print(" => " +nextNode);
                dfs2(visited, adj, nextNode, destination, depth+1);
            }else{
                for(int i=1;i<adj[nodeIdx].length;i++){
                    int nextNode = i;
                    if(adj[nodeIdx][i]==true && visited[nextNode]==false) {
                        System.out.print(" => " +nextNode);
                        if(!visited[i]) dfs2(visited, adj, nextNode, destination, depth+1);
                    }
                }
    
            }
        }
    }   
    public static void main(String arg[]){
//        int n = 3;
//        int[][] roads = {{1,2}, {2,3}};
//        int[] sources = {2,3};
//        int destination = 1;
        int n = 5;
        int[][] roads = {{1,2},{1,4},{2,4},{2,5},{4,5}};
        int[] sources = {1,3,5};
        int destination = 5;
        Question3 s = new Question3();
        int[] result = s.solution(n, roads, sources, destination);    //{1, 2}

        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }

    }
}

