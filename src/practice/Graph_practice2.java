package practice;

import java.util.LinkedList;
import java.util.Scanner;


class Graph{
    static LinkedList<Integer>[] adj;
    static boolean[] visited;

    public Graph(int n) {
        
        visited = new boolean[n+1];

        for(int i=0;i<=n;i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public static void addEdge(int v1, int v2){
        adj[v1].add(v2);
        adj[v2].add(v1);
    }
}


public class Graph_practice2 {    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        Graph graph = new Graph(n);
        for(int i=0;i<n;i++){
            graph.addEdge(sc.nextInt(), sc.nextInt());
        }
    
    }
}
